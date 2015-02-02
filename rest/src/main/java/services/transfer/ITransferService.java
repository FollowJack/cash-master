package services.transfer;

import model.dtos.*;

/**
 * Created by Deniel on 28.01.2015.
 */
public interface ITransferService {
    Result<BalanceSheetRecordDto> transfer(AccountDto target, AccountDto source,CategoryDto category, double balance, String message);

    void update(long balanceSheetRecordId, TransactionDto transaction);
}
