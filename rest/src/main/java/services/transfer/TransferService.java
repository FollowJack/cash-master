package services.transfer;

import model.dtos.*;
import repository.IAccountRepository;
import repository.IBalanceSheetRecordRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Date;

/**
 * Created by Deniel on 28.01.2015.
 */
@RequestScoped
public class TransferService implements ITransferService {

    @Inject
    IAccountRepository _accountRepository;
    @Inject
    IBalanceSheetRecordRepository _balanceSheetRecordRepository;

    public TransferService() {
    }

    @Override
    public Result<BalanceSheetRecordDto> transfer(AccountDto target, AccountDto source, CategoryDto category, double balance, Date targetMonth, Date executionDate, String message) {
        Result<BalanceSheetRecordDto> result = new Result<>();

        if (!areConditionsValid(target, source, balance)) {
            result.hasError = true;
            return result;
        }

        BalanceSheetRecordDto record = CreateBalanceSheetRecord(target, source, category, balance,targetMonth,executionDate, message);

        if (record == null) {
            result.hasError = true;
            return result;
        }

        SaveTransferRecord(record);

        result.returnValue = record;

        return result;
    }

    @Override
    public void update(long balanceSheetRecordId, TransactionDto transaction) {
        //Todo
    }

    public void SaveTransferRecord(BalanceSheetRecordDto balanceSheetRecord) {
        //decrease sourcce
        AccountDto source = balanceSheetRecord.getSource();
        if (source != null) {
            Double balanceBefore = source.getBalance();
            Double balanceAfter = source.getBalance() - balanceSheetRecord.getTransferAmount();
            source.setBalance(balanceAfter);
            _accountRepository.update(source);

            balanceSheetRecord.setBalanceBeforeTransactionSource(balanceBefore);
            balanceSheetRecord.setBalanceAfterTransactionSource(balanceAfter);
        }

        //increase target
        AccountDto target = balanceSheetRecord.getTarget();
        if (target != null) {
            Double balanceBefore = target.getBalance();
            Double balanceAfter = target.getBalance() + balanceSheetRecord.getTransferAmount();
            target.setBalance(balanceAfter);
            _accountRepository.update(target);

            balanceSheetRecord.setBalanceBeforeTransactionTarget(balanceBefore);
            balanceSheetRecord.setBalanceAfterTransactionTarget(balanceAfter);
        }

        //save record
        _balanceSheetRecordRepository.create(balanceSheetRecord);
    }

    private BalanceSheetRecordDto CreateBalanceSheetRecord(AccountDto target, AccountDto source, CategoryDto category, double balance, Date targetMonth,Date executionDate,String message) {
        BalanceSheetRecordDto result = new BalanceSheetRecordDto();
        result.setCategory(category);
        result.setName(message);
        result.setSource(source);
        result.setTransferAmount(balance);
        result.setTarget(target);
        result.setTargetMonth(targetMonth);
        result.setCreatedOn(new Date());
        result.setExecutionDate(executionDate);

        return result;
    }

    private boolean areConditionsValid(AccountDto target, AccountDto source, double balance) {
        if ((target == null && source == null) || balance == 0)
            return false;

        return true;
    }
}
