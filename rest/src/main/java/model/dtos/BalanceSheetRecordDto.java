package model.dtos;

import java.util.Date;

/**
 * Created by Deniel on 21.01.2015.
 */
public class BalanceSheetRecordDto {

    private String name;
    private double transferAmount;
    private Date targetMonth;
    private Date createdOn;
    private Date modifiedOn;

    //@ManyToOne
    private CategoryDto category;
    //@ManyToOne
    private AccountDto source;
    //@ManyToOne
    private AccountDto target;

    public BalanceSheetRecordDto(){}


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(double transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public void setCategory(CategoryDto category) {
        this.category = category;
    }

    public AccountDto getSource() {
        return source;
    }

    public void setSource(AccountDto source) {
        this.source = source;
    }

    public AccountDto getTarget() {
        return target;
    }

    public void setTarget(AccountDto target) {
        this.target = target;
    }

    public Date getTargetMonth() {
        return targetMonth;
    }

    public void setTargetMonth(Date targetMonth) {
        this.targetMonth = targetMonth;
    }
}
