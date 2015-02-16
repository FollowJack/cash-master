package services.rest;

import model.dtos.BalanceSheetRecordDto;
import model.dtos.CategoryDto;
import model.dtos.CategoryWithRecordsDto;
import repository.CategoryRepository;
import repository.IBalanceSheetRecordRepository;

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
@Path("/categories")
@Stateless
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class CategoryRestService {

    @Inject
    private CategoryRepository _categoryRepository;
    @Context
    private UriInfo uriInfo;

    @GET
    public List<CategoryDto> get() {
        return _categoryRepository.get();
    }


    @Path("/{id}")
    @GET
    public CategoryDto get(@PathParam("id") long id) {
        CategoryDto result = _categoryRepository.getDto(id);
        return result;
    }

}
