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

/**
 * Created by Deniel on 03.02.2015.
 */
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
    void init() {
        createAccounts();
        createCategories();

        doExampleTransactions();
    }

    //ToDo: Only for test reasons --> so delete it in productiv
    private void doExampleTransactions() {
        AccountDto bank = _accountRepository.get(1);
        AccountDto wallet = _accountRepository.get(2);
        AccountDto savings = _accountRepository.get(3);

        CategoryDto saveCategory = _categoryRepository.get(8);
        CategoryDto transferCategory = _categoryRepository.get(9);

        _transferService.transfer(savings,null,saveCategory,500,new Date(),new Date() , "TestTransfer 1");
        _transferService.transfer(bank,null,saveCategory,1000,new Date(),new Date() , "TestTransfer 2");
        _transferService.transfer(wallet,bank,transferCategory,500,new Date(),new Date() , "TestTransfer 3");
    }

    private void createCategories() {
        CategoryDto category1 = new CategoryDto();
        category1.setId(1);
        category1.setName("Living expenses");

        CategoryDto category2 = new CategoryDto();
        category2.setId(2);
        category2.setName("Basic food");

        CategoryDto category3 = new CategoryDto();
        category3.setId(3);
        category3.setName("Canteen food");

        CategoryDto category4 = new CategoryDto();
        category4.setId(4);
        category4.setName("Fun food");

        CategoryDto category5 = new CategoryDto();
        category5.setId(5);
        category5.setName("Fun");

        CategoryDto category6 = new CategoryDto();
        category6.setId(6);
        category6.setName("Investment");

        CategoryDto category7 = new CategoryDto();
        category7.setId(7);
        category7.setName("Not traceable");

        CategoryDto category8 = new CategoryDto();
        category8.setId(8);
        category8.setName("Save money");

        CategoryDto category9 = new CategoryDto();
        category9.setId(9);
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
        account1.setId(1);
        account1.setBalance(0);
        account1.setCreateOn(new Date());
        account1.setName("Bank");

        AccountDto account2 = new AccountDto();
        account2.setId(2);
        account2.setBalance(0);
        account2.setCreateOn(new Date());
        account2.setName("Wallet");

        AccountDto account3 = new AccountDto();
        account3.setId(3);
        account3.setBalance(0);
        account3.setCreateOn(new Date());
        account3.setName("Savings");

        _accountRepository.create(account1);
        _accountRepository.create(account2);
        _accountRepository.create(account3);
    }
}
