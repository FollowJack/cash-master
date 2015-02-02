package repository;

import model.dtos.AccountDto;

import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
public interface IAccountRepository {

    List<AccountDto> get();
    AccountDto get(long id);
    AccountDto create(AccountDto account);
    void save(AccountDto account);
    void update(AccountDto account);
    void delete(long id);

}
