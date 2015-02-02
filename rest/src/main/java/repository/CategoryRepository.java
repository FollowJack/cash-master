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

    public CategoryDto get(String name) {
        for (CategoryDto category : categories){
            if(category.getName().equals(name))
                return category;
        }

        return null;
    }

    public void delete(long id) {
        categories.remove((int) id - 1);
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

        ArrayList<CategoryDto> result = new ArrayList<>();
        result.add(category1);
        result.add(category2);
        result.add(category3);
        result.add(category4);

        return result;
    }

}
