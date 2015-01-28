package rest;

import model.dtos.CategoryDto;
import repository.CategoryRepository;

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
@Path("/category")
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
        CategoryDto result = _categoryRepository.get(id);
        return result;
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") long id) {
        _categoryRepository.delete(id);
    }

    @POST
    public CategoryDto create(CategoryDto categoryDto) {
        if (categoryDto == null)
            throw new BadRequestException();

        categoryDto = _categoryRepository.create(categoryDto);

        return categoryDto;
    }


    @PUT
    public Response update(CategoryDto categoryDto) {
        if (categoryDto == null)
            throw new BadRequestException();

        _categoryRepository.update(categoryDto);

        return Response.ok().build();
    }
}
