package repository;

import model.dtos.AccountDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
@ApplicationScoped
public class AccountRepository implements IAccountRepository {

    private ArrayList<AccountDto> accounts = new ArrayList<>();

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
