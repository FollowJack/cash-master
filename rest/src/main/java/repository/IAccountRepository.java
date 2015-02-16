package repository;

import model.dtos.AccountDto;
import model.entities.Account;

import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
public interface IAccountRepository {

    List<AccountDto> get();
    Account get(long id);
    AccountDto getDto(long id);
    Account create(AccountDto account);
    void update(AccountDto account);
}
