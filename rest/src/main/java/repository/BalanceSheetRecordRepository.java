package repository;

import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;
import model.dtos.CategoryDto;
import model.entities.Account;
import model.entities.BalanceSheetRecord;
import model.entities.Category;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;
import java.util.List;

/**
 * Created by Deniel on 28.01.2015.
 */
@Stateless
public class BalanceSheetRecordRepository implements IBalanceSheetRecordRepository {

    @PersistenceContext
    private EntityManager em;
    @Inject
    private CategoryRepository _categoryRepository;
    @Inject
    private IAccountRepository _accountRepository;

    @Override
         public List<BalanceSheetRecordDto> get() {
        List<BalanceSheetRecordDto> result = em.createQuery(
                "select new model.dtos.BalanceSheetRecordDto(b.id,b.source,b.target,b.category,b.createdOn,b.executionDate,b.modifiedOn,b.name,b.targetMonth,b.transferAmount,b.balanceBeforeTransactionSource,b.balanceBeforeTransactionTarget,b.balanceAfterTransactionSource,b.balanceAfterTransactionTarget) " +
                        "from BalanceSheetRecord b order by executionDate desc,b.id desc ", BalanceSheetRecordDto.class)
                .getResultList();
        return result;
    }

    @Override
    public BalanceSheetRecord get(long id) {
        BalanceSheetRecord result = em.find(BalanceSheetRecord.class, id);
        return result;
    }


    @Override
    public List<BalanceSheetRecordDto> getCategory(long categoryId) {
        List<BalanceSheetRecordDto> result = em.createQuery(
                "select new model.dtos.BalanceSheetRecordDto(b.id,b.source,b.target,b.category,b.createdOn,b.executionDate,b.modifiedOn,b.name,b.targetMonth,b.transferAmount,b.balanceBeforeTransactionSource,b.balanceBeforeTransactionTarget,b.balanceAfterTransactionSource,b.balanceAfterTransactionTarget) " +
                        "from BalanceSheetRecord b where b.category.id=:categoryId order by executionDate desc,b.id desc ", BalanceSheetRecordDto.class)
                .setParameter("categoryId", categoryId)
                .getResultList();
        return result;
    }

    @Override
    public List<BalanceSheetRecordDto> get(CategoryDto category, Date startTime, Date endTime) {
        List<BalanceSheetRecordDto> result = em.createQuery(
                "select new model.dtos.BalanceSheetRecordDto(b.id,b.source,b.target,b.category,b.createdOn,b.executionDate,b.modifiedOn,b.name,b.targetMonth,b.transferAmount,b.balanceBeforeTransactionSource,b.balanceBeforeTransactionTarget,b.balanceAfterTransactionSource,b.balanceAfterTransactionTarget) " +
                        "from BalanceSheetRecord b where b.category.id = :categoryId and b.targetMonth >= :startTime and b.targetMonth < :endTime " +
                        "order by executionDate desc,b.id desc ", BalanceSheetRecordDto.class)
                .setParameter("categoryId", category.getId())
                .setParameter("startTime", startTime)
                .setParameter("endTime", endTime)
                .getResultList();
        return result;
    }

    @Override
    public List<BalanceSheetRecordDto> getAccount(long accountId) {
        List<BalanceSheetRecordDto> result = em.createQuery(
                "select new model.dtos.BalanceSheetRecordDto(b.id,b.source,b.target,b.category,b.createdOn,b.executionDate,b.modifiedOn,b.name,b.targetMonth,b.transferAmount,b.balanceBeforeTransactionSource,b.balanceBeforeTransactionTarget,b.balanceAfterTransactionSource,b.balanceAfterTransactionTarget) " +
                        "from BalanceSheetRecord b where b.source.id=:accountId or b.target.id=:accountId " +
                        "order by executionDate desc,b.id desc ", BalanceSheetRecordDto.class)
                .setParameter("accountId", accountId)
                .getResultList();
        return result;
    }

    @Override
    public List<BalanceSheetRecordDto> get(AccountDto account, Date startTime, Date endTime) {
        List<BalanceSheetRecordDto> result = em.createQuery(
                "select new model.dtos.BalanceSheetRecordDto(b.id,b.source,b.target,b.category,b.createdOn,b.executionDate,b.modifiedOn,b.name,b.targetMonth,b.transferAmount,b.balanceBeforeTransactionSource,b.balanceBeforeTransactionTarget,b.balanceAfterTransactionSource,b.balanceAfterTransactionTarget) " +
                        "from BalanceSheetRecord b where (b.source.id = :accountId or b.target.id = :accountId) and b.targetMonth >= :startTime and b.targetMonth < :endTime " +
                        "order by executionDate desc,b.id desc ", BalanceSheetRecordDto.class)
                .setParameter("accountId", account.getId())
                .setParameter("startTime", startTime)
                .setParameter("endTime", endTime)
                .getResultList();
        return result;
    }


    @Override
    public void create(BalanceSheetRecordDto balanceSheetRecord) {
        if (balanceSheetRecord == null)
            return;

        //get category
        Category category = _categoryRepository.get(balanceSheetRecord.getCategory().getId());
        //get source
        Account source = null;
        if (balanceSheetRecord.getSource() != null)
            source = _accountRepository.get(balanceSheetRecord.getSource().getId());
        //get target
        Account target = null;
        if (balanceSheetRecord.getTarget() != null)
            target = _accountRepository.get(balanceSheetRecord.getTarget().getId());

        //create new record and fill properties
        BalanceSheetRecord entity = new BalanceSheetRecord();
        balanceSheetRecord.updateSource(entity, category, source, target);

        em.persist(entity);
    }

}
