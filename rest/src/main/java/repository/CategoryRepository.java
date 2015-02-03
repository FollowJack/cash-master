package repository;

import model.dtos.CategoryDto;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

/**
 * Created by Deniel on 26.01.2015.
 */
@ApplicationScoped
public class CategoryRepository {

    private ArrayList<CategoryDto> categories = new ArrayList<>();

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
}
