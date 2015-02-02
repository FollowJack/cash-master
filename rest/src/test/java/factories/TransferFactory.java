package factories;

import model.dtos.AccountDto;
import model.dtos.CategoryDto;

/**
 * Created by Deniel on 28.01.2015.
 */
public class TransferFactory {

    public static AccountDto getBank(double balance){
        AccountDto result = getAccount("Bank",balance);
        return result;
    }

    public static AccountDto getWallet(double balance){
        AccountDto result = getAccount("Wallet",balance);
        return result;
    }

    public static AccountDto getSavings(double balance){
        AccountDto result = getAccount("Savings",balance);
        return result;
    }

    public static AccountDto getAccount(String name, double balance){
        AccountDto result = new AccountDto();
        result.setName(name);
        result.setBalance(balance);
        return result;
    }

    public static CategoryDto getSavingCategory() {
        CategoryDto result = new CategoryDto();
        result.setName("Savings");
        return result;
    }
}
