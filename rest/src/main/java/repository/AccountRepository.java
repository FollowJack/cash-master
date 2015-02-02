package repository;

import model.dtos.AccountDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
@ApplicationScoped
public class AccountRepository implements IAccountRepository {

    private ArrayList<AccountDto> accounts = fillExampleAccounts();

    private ArrayList<AccountDto> fillExampleAccounts() {
        AccountDto account1 = new AccountDto();
        account1.setId(1);
        account1.setBalance(0);
        account1.setCreateOn(new Date());
        account1.setName("Living expenses");

        AccountDto account2= new AccountDto();
        account2.setId(2);
        account2.setBalance(0);
        account2.setCreateOn(new Date());
        account2.setName("Basic food");

        AccountDto account3 = new AccountDto();
        account3.setId(3);
        account3.setBalance(0);
        account3.setCreateOn(new Date());
        account3.setName("Canteen food");

        ArrayList<AccountDto> result = new ArrayList<>();
        result.add(account1);
        result.add(account2);
        result.add(account3);

        return result;
    }

    @Override
    public List<AccountDto> get() {
        return accounts;
    }

    @Override
    public AccountDto get(long id) {
        AccountDto result = accounts.get((int) id-1);
        return result;
    }

    @Override
    public AccountDto create(AccountDto account) {
        account.setId(accounts.size() + 1);
        accounts.add(account);
        return account;
    }

    @Override
    public void save(AccountDto account) {
        accounts.add(account);
    }

    @Override
    public void update(AccountDto account) {
        int index =  ((int) account.getId())-1;
        accounts.set(index, account);
    }

    @Override
    public void delete(long id) {
        accounts.remove((int) id - 1);
    }
}
