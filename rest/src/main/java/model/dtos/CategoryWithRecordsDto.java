package model.dtos;

/**
 * Created by Deniel on 21.01.2015.
 */
public class CategoryWithRecordsDto {

    private long id;
    private String name;
    private Double expenses;

    public CategoryWithRecordsDto() {

    }

    public CategoryWithRecordsDto(long id, String name,Double expenses) {
        this.id = id;
        this.name = name;
        this.expenses = expenses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getExpenses() {
        return expenses;
    }

    public void setExpenses(Double expenses) {
        this.expenses = expenses;
    }
}
