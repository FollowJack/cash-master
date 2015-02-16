package repository;

import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;
import model.dtos.CategoryDto;
import model.entities.BalanceSheetRecord;

import java.util.Date;
import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
public interface IBalanceSheetRecordRepository {

    List<BalanceSheetRecordDto> get();
    BalanceSheetRecord get(long id);

    List<BalanceSheetRecordDto> getCategory(long categoryId);
    List<BalanceSheetRecordDto> get(CategoryDto category, Date startTime, Date endTime);

    List<BalanceSheetRecordDto> getAccount(long accountId);
    List<BalanceSheetRecordDto> get(AccountDto account, Date startTime, Date endTime);

    void create(BalanceSheetRecordDto balanceSheetRecord);



}
