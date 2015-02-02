package services.rest;

import model.dtos.AccountDto;
import repository.IAccountRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by Deniel on 21.01.2015.
 */
@Path("/account")
@Stateless
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class AccountRestService {

    @Inject
    private IAccountRepository _accountRepository;
    @Context
    private UriInfo uriInfo;

    @GET
    public List<AccountDto> get() {
        return _accountRepository.get();
    }

    @Path("/{id}")
    @GET
    public AccountDto get(@PathParam("id") long id) {
        AccountDto result = _accountRepository.get(id);
        return result;
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") long id) {
        _accountRepository.delete(id);
    }

    @POST
    public AccountDto create(AccountDto account) {
        if (account == null)
            throw new BadRequestException();

        account  = _accountRepository.create(account);

        return account;
    }


    @PUT
    public Response update(AccountDto account) {
        if (account == null)
            throw new BadRequestException();

        _accountRepository.update(account);

        return Response.ok().build();
    }
}
