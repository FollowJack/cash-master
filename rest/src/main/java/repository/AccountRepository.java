package repository;

import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;
import model.entities.Account;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
@Stateless
public class AccountRepository implements IAccountRepository {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private IBalanceSheetRecordRepository _balanceSheetRecordRepository;

    @Override
    public List<AccountDto> get() {

        List<AccountDto> result = em.createQuery(
                "select new model.dtos.AccountDto(a.id, a.name, a.balance,a.glyphIcon) " +
                        "from Account a", AccountDto.class)
                .getResultList();

        return result;
    }

    @Override
    public Account get(long id) {

        Account result = em.find(Account.class, id);
        return result;
    }

    @Override
    public AccountDto getDto(long id) {
        Account entity = get(id);

        if(entity == null)
            return null;

        AccountDto result = new AccountDto(entity);

        return result;
    }

    @Override
    public Account create(AccountDto account) {
        Account result = new Account();
        account.updateSource(result);
        em.persist(result);
        result = get(result.getId());
        return result;
    }

    @Override
    public void update(AccountDto account) {
        if(account == null)
            return;
        Account entity = get(account.getId());
        account.updateSource(entity);
        em.merge(entity);
    }
}
