package services.rest;

import model.dtos.AccountDto;
import model.dtos.CategoryDto;
import model.dtos.TransactionDto;
import repository.CategoryRepository;
import repository.IAccountRepository;
import services.transfer.ITransferService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * Created by Deniel on 30.01.2015.
 */
@Path("/transfer")
@Stateless
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class TransactionRestService {

    @Inject
    private IAccountRepository _accountRepository;
    @Inject
    private ITransferService _transferService;
    @Inject
    private CategoryRepository _categoryRepository;
    @Context
    private UriInfo uriInfo;

    @POST
    public TransactionDto create(TransactionDto transaction) {
        //check conditions
        if (transaction == null)
            throw new BadRequestException();

        //get source object
        AccountDto target = _accountRepository.get(transaction.getTargetId());

        //get target object
        AccountDto source = _accountRepository.get(transaction.getAccountSourceId());

        //get category
        CategoryDto category = _categoryRepository.get(transaction.getCategoryName());

        //transfer
        _transferService.transfer(target,source,category,transaction.getAmount(),transaction.getMessage());

        return transaction;
    }


    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") long balanceSheetRecordId, TransactionDto transaction) {
        if (balanceSheetRecordId == 0)
            throw new BadRequestException();

        _transferService.update(balanceSheetRecordId, transaction);

        return Response.ok().build();
    }
}