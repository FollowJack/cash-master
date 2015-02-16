package services.rest;

import model.dtos.AccountDto;
import model.dtos.BalanceSheetRecordDto;
import model.dtos.CategoryDto;
import model.dtos.TransactionDto;
import repository.CategoryRepository;
import repository.IAccountRepository;
import repository.IBalanceSheetRecordRepository;
import services.transfer.ITransferService;
import util.date.DateHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.Date;
import java.util.List;

/**
 * Created by Deniel on 30.01.2015.
 */
@Path("/records")
@Stateless
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class BalanceSheetRecordRestService {

    @Inject
    private IAccountRepository _accountRepository;
    @Inject
    private CategoryRepository _categoryRepository;
    @Inject
    private IBalanceSheetRecordRepository _balanceSheetRecordRepository;
    @Inject
    private ITransferService _transferService;
    @Context
    private UriInfo uriInfo;

    @GET
    public List<BalanceSheetRecordDto> get(){
        return _balanceSheetRecordRepository.get();
    }

    @GET
    @Path("/category/{id}")
    public List<BalanceSheetRecordDto> getCategoryRecords(@PathParam("id") long categoryId){
        return _balanceSheetRecordRepository.getCategory(categoryId);
    }

    @GET
    @Path("/category/{id}/month/{month}/year/{year}")
    public List<BalanceSheetRecordDto> getCategoryRecordsMonth(@PathParam("id") long categoryId,@PathParam("month") int month,@PathParam("year") int year){
        CategoryDto category = _categoryRepository.getDto(categoryId);
        Date start = DateHelper.getMonthDate(month + "." + year);
        Date end = DateHelper.addMonth(start,1);

        List<BalanceSheetRecordDto> result = _balanceSheetRecordRepository.get( category, start, end);

        return result;
    }

    @GET
    @Path("/category/{id}/year/{year}")
    public List<BalanceSheetRecordDto> getCategoryRecordsYear(@PathParam("id") long categoryId,@PathParam("year") int year){
        CategoryDto category = _categoryRepository.getDto(categoryId);
        Date start = DateHelper.getMonthDate("01." + year);
        Date end = DateHelper.addMonth(start, 12);

        List<BalanceSheetRecordDto> result = _balanceSheetRecordRepository.get( category, start, end);

        return result;
    }

    @GET
    @Path("/account/{id}")
    public List<BalanceSheetRecordDto> getAccountRecords(@PathParam("id") long accountId){
        return _balanceSheetRecordRepository.getAccount(accountId);
    }


    @GET
    @Path("/account/{id}/month/{month}/year/{year}")
    public List<BalanceSheetRecordDto> getAccountRecordsMonth(@PathParam("id") long accountId,@PathParam("month") String month,@PathParam("year") String year){
        AccountDto account= _accountRepository.getDto(accountId);
        Date start = DateHelper.getMonthDate(month + "." + year);
        Date end = DateHelper.addMonth(start,1);

        List<BalanceSheetRecordDto> result = _balanceSheetRecordRepository.get(account, start, end);

        return result;
    }

    @GET
    @Path("/account/{id}/year/{year}")
    public List<BalanceSheetRecordDto> getAccountRecordsYear(@PathParam("id") long accountId,@PathParam("year") String year){
        AccountDto account= _accountRepository.getDto(accountId);
        Date start = DateHelper.getMonthDate("01." + year);
        Date end = DateHelper.addMonth(start, 12);

        List<BalanceSheetRecordDto> result = _balanceSheetRecordRepository.get(account, start, end);

        return result;
    }

    @POST
    public TransactionDto create(TransactionDto transaction) {
        //check conditions
        if (transaction == null)
            throw new BadRequestException();

        //get source object
        AccountDto target = _accountRepository.getDto(transaction.getAccountTargetId());

        //get target object
        AccountDto source = _accountRepository.getDto(transaction.getAccountSourceId());

        //get category
        CategoryDto category = _categoryRepository.getDto(transaction.getCategoryId());

        //transfer
        _transferService.transfer(target,source,category,transaction.getAmount(),transaction.getTargetMonth(),transaction.getExecutionDate(),transaction.getMessage());

        return transaction;
    }
}