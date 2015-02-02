package services.statistics;

import model.dtos.Result;
import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;

import java.sql.Date;
import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
public interface IStatisticServiceAccount {
    Result<Double> calculateSumForTimeRange(AccountDto account, Date startTime, Date endTime);

    double calculateSum(List<BalanceSheetRecordDto> records, AccountDto account);

    double calculateMax(List<BalanceSheetRecordDto> records, AccountDto account);
}
