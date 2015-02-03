package repository;

import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;

import java.sql.Date;
import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
public interface IBalanceSheetRecordRepository {
    void save(BalanceSheetRecordDto record);

    List<BalanceSheetRecordDto> get(AccountDto account, Date startTime, Date endTime);

    List<BalanceSheetRecordDto> get();
}
