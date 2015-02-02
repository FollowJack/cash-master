package services.statistics;

import model.dtos.Result;
import infrastructure.exceptions.AccountNotExistException;
import infrastructure.exceptions.DateWrongSetException;
import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;
import repository.BalanceSheetRecordRepository;
import repository.IBalanceSheetRecordRepository;

import java.sql.Date;
import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
public class StatisticServiceAccount implements IStatisticServiceAccount {

    IBalanceSheetRecordRepository _balanceSheetRecordService;

    public StatisticServiceAccount() {
        _balanceSheetRecordService = new BalanceSheetRecordRepository();
    }

    @Override
    public Result<Double> calculateSumForTimeRange(AccountDto account, Date startTime, Date endTime) {

        //check conditions
        try {
            checkConditions(account, startTime, endTime);
        } catch (DateWrongSetException e) {
            e.printStackTrace(); //Handle Exeption
        }

        //get records
        List<BalanceSheetRecordDto> records = _balanceSheetRecordService.Get(account, startTime, endTime);

        //calculate sum
        double balanceSum = calculateSum(records, account);

        //result
        Result<Double> result = new Result<>();
        result.returnValue = balanceSum;

        return result;
    }

    private void checkConditions(AccountDto account, Date startTime, Date endTime) throws DateWrongSetException {
        try {
            isAccountExisting(account);
        } catch (AccountNotExistException e) {
            e.printStackTrace(); //ToDo Handle Exeption
        }

        if (startTime == null || endTime == null || startTime.after(endTime))
            throw new DateWrongSetException(startTime, endTime);
    }

    private void isAccountExisting(AccountDto account) throws AccountNotExistException {
        if (account == null)
            throw new AccountNotExistException();
    }

    public double calculateSum(List<BalanceSheetRecordDto> records, AccountDto account){

        try {
            isAccountExisting(account);
        } catch (AccountNotExistException e) {
            e.printStackTrace();
            return 0;
        }

        double result = 0;

        for (BalanceSheetRecordDto record : records) {
            //Case 1 : Source is account
            if (record.getSource().equals(account))
                result -= record.getTransferAmount();

                //Case 2 : target is account
            else if (record.getTarget().equals(account))
                result += record.getTransferAmount();
        }

        return result;
    }

    @Override
    public double calculateMax(List<BalanceSheetRecordDto> records, AccountDto account) {
        try {
            isAccountExisting(account);
        } catch (AccountNotExistException e) {
            e.printStackTrace();
            return 0;
        }

        double result = 0;

        for (BalanceSheetRecordDto record : records) {
            //Case 1 : Source is account
            if (record.getSource().equals(account))
                result = result > -record.getTransferAmount() ? result : record.getTransferAmount();

                //Case 2 : target is account
            else if (record.getTarget().equals(account))
                result = result > record.getTransferAmount() ? result : record.getTransferAmount();
        }
        return result;
    }
}
