package services.rest;

import model.dtos.AccountDto;
import repository.IAccountRepository;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * Created by Deniel on 21.01.2015.
 */
@Path("/accounts")
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
        AccountDto result = _accountRepository.getDto(id);
        return result;
    }
}
