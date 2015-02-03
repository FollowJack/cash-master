package services.transfer;

import model.dtos.*;

import java.util.Date;

/**
 * Created by Deniel on 28.01.2015.
 */
public interface ITransferService {
    Result<BalanceSheetRecordDto> transfer(AccountDto target, AccountDto source, CategoryDto category, double balance, Date targetMonth, Date executionDate, String message);

    void update(long balanceSheetRecordId, TransactionDto transaction);
}
