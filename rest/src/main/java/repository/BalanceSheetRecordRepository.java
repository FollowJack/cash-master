package repository;

import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;

import javax.enterprise.context.ApplicationScoped;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
@ApplicationScoped
public class BalanceSheetRecordRepository implements IBalanceSheetRecordRepository {

    private ArrayList<BalanceSheetRecordDto> balanceSheetRecords = new ArrayList<>();

    @Override
    public void save(BalanceSheetRecordDto record) {
        balanceSheetRecords.add(record);
    }

    @Override
    public List<BalanceSheetRecordDto> get(AccountDto account, Date startTime, Date endTime) {
        List<BalanceSheetRecordDto> result = new ArrayList<>();
        //filter
        for (BalanceSheetRecordDto record : balanceSheetRecords) {
            if (record.getCreatedOn().before(startTime))
                continue;
            if (record.getCreatedOn().after(endTime))
                continue;

            if (record.getSource().getId() == account.getId() || record.getTarget().getId() == account.getId())
                result.add(record);
        }

        return result;
    }

    @Override
    public List<BalanceSheetRecordDto> get() {
        return balanceSheetRecords;
    }
}
