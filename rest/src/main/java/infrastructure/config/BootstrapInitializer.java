package infrastructure.config;

import model.dtos.AccountDto;
import model.dtos.CategoryDto;
import repository.CategoryRepository;
import repository.IAccountRepository;
import services.transfer.ITransferService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.Date;


@Startup
@Singleton
public class BootstrapInitializer {

    @Inject
    IAccountRepository _accountRepository;
    @Inject
    CategoryRepository _categoryRepository;
    @Inject
    ITransferService _transferService;

    @PostConstruct
    private void init() {
        if (_accountRepository.get().isEmpty())
            createAccounts();
        if (_categoryRepository.get().isEmpty())
            createCategories();
    }

    private void createCategories() {
        CategoryDto category1 = new CategoryDto();
        category1.setName("Living expenses");

        CategoryDto category2 = new CategoryDto();
        category2.setName("Basic food");

        CategoryDto category3 = new CategoryDto();
        category3.setName("Canteen food");

        CategoryDto category4 = new CategoryDto();
        category4.setName("Fun food");

        CategoryDto category5 = new CategoryDto();
        category5.setName("Fun");

        CategoryDto category6 = new CategoryDto();
        category6.setName("Investment");

        CategoryDto category7 = new CategoryDto();
        category7.setName("Not traceable");

        CategoryDto category8 = new CategoryDto();
        category8.setName("Save money");

        CategoryDto category9 = new CategoryDto();
        category9.setName("Transfer");

        _categoryRepository.create(category1);
        _categoryRepository.create(category2);
        _categoryRepository.create(category3);
        _categoryRepository.create(category4);
        _categoryRepository.create(category5);
        _categoryRepository.create(category6);
        _categoryRepository.create(category7);
        _categoryRepository.create(category8);
        _categoryRepository.create(category9);
    }

    private void createAccounts() {

        AccountDto account1 = new AccountDto();
        account1.setBalance(0);
        account1.setCreateOn(new Date());
        account1.setName("Bank");

        AccountDto account2 = new AccountDto();
        account2.setBalance(0);
        account2.setCreateOn(new Date());
        account2.setName("Wallet");

        AccountDto account3 = new AccountDto();
        account3.setBalance(0);
        account3.setCreateOn(new Date());
        account3.setName("Savings");

        _accountRepository.create(account1);
        _accountRepository.create(account2);
        _accountRepository.create(account3);
    }
}
