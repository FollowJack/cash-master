package repository;

import model.dtos.CategoryDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

/**
 * Created by Deniel on 26.01.2015.
 */
@ApplicationScoped
public class CategoryRepository {

    private ArrayList<CategoryDto> categories = fillExampleCategories();


    public ArrayList<CategoryDto> get() {
        return categories;
    }
    public CategoryDto get(long id) {
        CategoryDto result = categories.get((int) id-1);
        return result;
    }
    public void delete(long id) {
        categories.remove((int) id-1);
    }
    public CategoryDto create(CategoryDto categoryDto) {
        categoryDto.setId(categories.size()+1);
        categories.add(categoryDto);
        return categoryDto;
    }
    public void update(CategoryDto category) {
        int index =  ((int) category.getId())-1;
        categories.set(index, category);
    }


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
}
