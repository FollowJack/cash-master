package services.transfer;

import model.dtos.*;
import repository.AccountRepository;
import repository.BalanceSheetRecordRepository;
import repository.IAccountRepository;
import repository.IBalanceSheetRecordRepository;

import javax.enterprise.context.RequestScoped;

/**
 * Created by Deniel on 28.01.2015.
 */
@RequestScoped
public class TransferService implements ITransferService {

    IAccountRepository _accountRepository;
    IBalanceSheetRecordRepository _balanceSheetRecordRepository;

    public TransferService(){
        _accountRepository = new AccountRepository();
        _balanceSheetRecordRepository = new BalanceSheetRecordRepository();
    }

    @Override
    public Result<BalanceSheetRecordDto> transfer(AccountDto target, AccountDto source,CategoryDto category, double balance, String message) {
        Result<BalanceSheetRecordDto> result = new Result<>();

        if(!areConditionsValid(target,source,balance)){
            result.hasError = true;
            return result;
        }

        BalanceSheetRecordDto record = CreateBalanceSheetRecord(target,source,category,balance,message);

        if(record == null){
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
        double sourceBalance = source.getBalance() - balanceSheetRecord.getTransferAmount();
        source.setBalance(sourceBalance);

        //increase target
        AccountDto target = balanceSheetRecord.getTarget();
        double targetBalance = target.getBalance() + balanceSheetRecord.getTransferAmount();
        target.setBalance(targetBalance);

        //save accounts
        _accountRepository.save(source);
        _accountRepository.save(target);

        //save record
        _balanceSheetRecordRepository.save(balanceSheetRecord);
    }

    private BalanceSheetRecordDto CreateBalanceSheetRecord(AccountDto target, AccountDto source, CategoryDto category, double balance,String message) {
        BalanceSheetRecordDto result = new BalanceSheetRecordDto();
        result.setCategory(category);
        result.setName(message);
        result.setSource(source);
        result.setTransferAmount(balance);
        result.setTarget(target);

        return result;
    }

    private boolean areConditionsValid(AccountDto target, AccountDto source, double balance) {
        if(target == null || source == null || balance == 0)
            return false;

        return true;
    }
}
