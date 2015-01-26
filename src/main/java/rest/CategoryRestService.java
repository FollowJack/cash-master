package rest;

import model.dtos.CategoryDto;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 21.01.2015.
 */
@Path("/category")
@Stateless
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class CategoryRestService {

    private ArrayList<CategoryDto> categories = fillExampleCategories();

    private ArrayList<CategoryDto> fillExampleCategories() {

        CategoryDto category1 = new CategoryDto();
        category1.setId(1);
        category1.setName("Bla");

        CategoryDto category2 = new CategoryDto();
        category2.setId(2);
        category2.setName("Bla2");

        CategoryDto category3 = new CategoryDto();
        category3.setId(3);
        category3.setName("Bla3");

        ArrayList<CategoryDto> result = new ArrayList<>();
        result.add(category1);
        result.add(category2);
        result.add(category3);

        return result;
    }

    @GET
    public List<CategoryDto> get(){
        return categories;
    }

/*    @GET
    public CategoryDto get(long id){

        CategoryDto result = categories.get((int) id);

        return result;
    }*/
}
