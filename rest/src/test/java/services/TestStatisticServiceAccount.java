package services;

import factories.TransferFactory;
import junit.framework.TestCase;
import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;
import org.junit.Before;
import org.junit.Test;
import services.statistics.IStatisticServiceAccount;
import services.statistics.StatisticServiceAccount;
import services.transfer.ITransferService;
import services.transfer.TransferService;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Deniel on 28.01.2015.
 */
public class TestStatisticServiceAccount {

    IStatisticServiceAccount statisticServiceAccount;
    AccountDto wallet;
    BalanceSheetRecordDto record1;
    BalanceSheetRecordDto record2;
    BalanceSheetRecordDto record3;

    @Before
    public void initialize() {
        // Arrange - get Service
        statisticServiceAccount = new StatisticServiceAccount();
        // Arrange - create test records
        wallet = TransferFactory.getWallet(500);
        // Arrange - create test records
        ITransferService transferService = new TransferService();
        record1 = transferService.transfer(wallet, TransferFactory.getBank(1000), TransferFactory.getSavingCategory(), 500, "").returnValue;
        record2 = transferService.transfer(wallet, TransferFactory.getBank(1000), TransferFactory.getSavingCategory(), 750, "").returnValue;
        record3 = transferService.transfer(wallet, TransferFactory.getBank(1000), TransferFactory.getSavingCategory(), -750, "").returnValue;
    }

    @Test
    public void TestCalculateSum() {

        // Arrange - create test records
        List<BalanceSheetRecordDto> records = new ArrayList<>();
        records.add(record1);
        records.add(record2);
        records.add(record3);

        // Act - calculate sum
        double result = statisticServiceAccount.calculateSum(records, wallet);

        // Assert - result true and sum correct
        TestCase.assertEquals(result, 500, 0.1);
    }

    @Test
    public void TestCalculateSum_withEmptyParameters() {

        // Arrange - create test records
        List<BalanceSheetRecordDto> records = new ArrayList<>();

        // Act - calculate sum
        double result = statisticServiceAccount.calculateSum(records, null);

        TestCase.assertEquals(result, 0, 0.1);
    }

    @Test
    public void TestCalculateSum_withEmptyRecords() {

        // Arrange - create test records
        List<BalanceSheetRecordDto> records = new ArrayList<>();

        // Act - calculate sum
        double result = statisticServiceAccount.calculateSum(records, wallet);

        // Assert - result should be 0
        TestCase.assertEquals(result, 0, 0.1);
    }

    @Test
    public void TestCalculateMax() {

        // Arrange - create test records
        List<BalanceSheetRecordDto> records = new ArrayList<>();
        records.add(record1);
        records.add(record2);
        records.add(record3);

        // Act - calculate sum
        double result = statisticServiceAccount.calculateMax(records, wallet);

        // Assert - result true and sum correct
        TestCase.assertEquals(result, 750, 0.1);
    }

    @Test
    public void TestCalculateMax_withEmptyParameters() {

        // Arrange - create test records
        List<BalanceSheetRecordDto> records = new ArrayList<>();

        // Act - calculate sum
        double result = statisticServiceAccount.calculateMax(records, null);

        TestCase.assertEquals(result, 0, 0.1);
    }

    @Test
    public void TestCalculateMax_withEmptyRecords() {

        // Arrange - create test records
        List<BalanceSheetRecordDto> records = new ArrayList<>();

        // Act - calculate sum
        double result = statisticServiceAccount.calculateMax(records, wallet);

        // Assert - result should be 0
        TestCase.assertEquals(result, 0, 0.1);
    }
}

