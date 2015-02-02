package services;

import factories.TransferFactory;
import model.dtos.Result;
import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;
import model.dtos.CategoryDto;
import org.junit.Before;
import org.junit.Test;
import services.transfer.ITransferService;
import services.transfer.TransferService;

import static org.junit.Assert.assertEquals;

/**
 * Created by Deniel on 28.01.2015.
 */
public class TestTransferService {

    AccountDto bank;
    AccountDto wallet;
    AccountDto savings;
    ITransferService transferService;
    CategoryDto category;

    int startBankBalance = 100;
    int startWalletBalance = 0;
    int startSavingsBalance = 0;


    @Before
    public void initialize() {
        // Arrange - get transferService
        transferService = new TransferService();

        bank = TransferFactory.getBank(startBankBalance);
        wallet = TransferFactory.getWallet(startWalletBalance);
        savings = TransferFactory.getSavings(startSavingsBalance);

        // Arrange - get category
        category = TransferFactory.getSavingCategory();
    }

    @Test
    public void TestTransfer() {
        // Act - transfer from bank to wallet to savings
        Result result1 = transferService.transfer(wallet, bank, category, 50, "");
        Result result2 = transferService.transfer(savings, wallet, category, 50, "");

        // Assert - Account balance
        assertEquals(((BalanceSheetRecordDto) result1.returnValue).getSource().getBalance(), 50,0.1);
        assertEquals(((BalanceSheetRecordDto) result2.returnValue).getSource().getBalance(), 0,0.1);
        assertEquals(((BalanceSheetRecordDto) result2.returnValue).getTarget().getBalance(), 50,0.1);
        assertEquals(false, result1.hasError);
        assertEquals(false, result2.hasError);
    }

    @Test
    public void TestTransfer_WithEmptyParameters() {

        // Act - transfer from bank to wallet to savings
        Result result1 = transferService.transfer(null, null, category, 50, "");
        Result result2 = transferService.transfer(null, null, category, 50, "");

        // Assert - Aocount balance
        assertEquals(true, result1.hasError);
        assertEquals(true, result2.hasError);
    }

    @Test
    public void TestTransfer_SourceIsResetWhenTargetIsNull() {

        // Act - transfer from bank to wallet to savings
        Result result1 = transferService.transfer(null, bank, category, 50, "");
        Result result2 = transferService.transfer(null, wallet, category, 50, "");

        // Assert - Aocount balance
        assertEquals(bank.getBalance(), 100,0.1);
        assertEquals(wallet.getBalance(), 0,0.1);
        assertEquals(true, result1.hasError);
        assertEquals(true, result2.hasError);
    }
}
