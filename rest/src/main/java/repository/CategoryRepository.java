package repository;

import model.dtos.CategoryDto;
import model.entities.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Deniel on 26.01.2015.
 */
@ApplicationScoped
public class CategoryRepository {

    @PersistenceContext
    private EntityManager em;

    public ArrayList<CategoryDto> get() {
        List<CategoryDto> result = em.createQuery("select new model.dtos.CategoryDto(c.id,c.name) from Category c", CategoryDto.class).getResultList();
        return (ArrayList<CategoryDto>) result;
    }

    public Category get(long id) {
        Category category = em.find(Category.class, id);
        if(category == null)
            return null;
        return category;
    }

    public CategoryDto getDto(long id) {
        Category category = get(id);
        if(category == null)
            return null;
        CategoryDto result = new CategoryDto(category);
        return result;
    }

    public void delete(long id) {
        Category entity = get(id);
        if(entity == null)
            return;
        em.remove(entity);
    }

    public Category create(CategoryDto categoryDto) {
        Category result = new Category();
        categoryDto.updateSource(result);
        em.persist(result);
        result = get(result.getId());
        return result;
    }

    public void update(CategoryDto category) {
        if(category == null)
            return;
        Category entity = get(category.getId());

        category.updateSource(entity);
        em.merge(entity);
    }
}
