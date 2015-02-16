package model.dtos;

import model.entities.Account;
import model.entities.BalanceSheetRecord;
import model.entities.Category;

import java.util.Date;

/**
 * Created by Deniel on 21.01.2015.
 */
public class BalanceSheetRecordDto {

    private long id;
    private String name;
    private Double transferAmount;
    private Date targetMonth;
    private Date executionDate;
    private Date createdOn;
    private Date modifiedOn;
    private Double balanceBeforeTransactionSource;
    private Double balanceAfterTransactionSource;
    private Double balanceBeforeTransactionTarget;
    private Double balanceAfterTransactionTarget;


    private CategoryDto category;
    private AccountDto source;
    private AccountDto target;

    public BalanceSheetRecordDto(){}
    public BalanceSheetRecordDto(long id, Account source,Account target,Category category,
                                 Date createdOn, Date executionDate, Date modifiedOn,
                                 String name, Date targetMonth, Double transferAmount,
                                 Double balanceBeforeTransactionSource,
                                 Double balanceBeforeTransactionTarget,
                                 Double balanceAfterTransactionSource,
                                 Double balanceAfterTransactionTarget){
        this.id = id;
        this.source = new AccountDto(source);
        this.target = new AccountDto(target);
        this.category = new CategoryDto(category);
        this.createdOn = createdOn;
        this.executionDate = executionDate;
        this.modifiedOn = modifiedOn;
        this.name = name;
        this.targetMonth = targetMonth;
        this.transferAmount= transferAmount;
        this.balanceBeforeTransactionSource = balanceBeforeTransactionSource;
        this.balanceBeforeTransactionTarget = balanceBeforeTransactionTarget;
        this.balanceAfterTransactionSource = balanceAfterTransactionSource;
        this.balanceAfterTransactionTarget = balanceAfterTransactionTarget;
    }


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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void updateSource(BalanceSheetRecord entity, Category category, Account source, Account target) {
        entity.setName(this.getName());
        entity.setModifiedOn(new Date());
        entity.setCreatedOn(this.getCreatedOn());
        entity.setExecutionDate(this.getExecutionDate());
        entity.setTargetMonth(this.getTargetMonth());
        entity.setTransferAmount(this.getTransferAmount());
        entity.setCategory(category);
        entity.setTarget(target);
        entity.setSource(source);
        entity.setBalanceBeforeTransactionSource(this.getBalanceBeforeTransactionSource());
        entity.setBalanceBeforeTransactionTarget(this.getBalanceBeforeTransactionTarget());
        entity.setBalanceAfterTransactionSource(this.getBalanceAfterTransactionSource());
        entity.setBalanceAfterTransactionTarget(this.getBalanceAfterTransactionTarget());

    }

    public Double getBalanceBeforeTransactionSource() {
        return balanceBeforeTransactionSource;
    }

    public void setBalanceBeforeTransactionSource(Double balanceBeforeTransactionSource) {
        this.balanceBeforeTransactionSource = balanceBeforeTransactionSource;
    }

    public Double getBalanceBeforeTransactionTarget() {
        return balanceBeforeTransactionTarget;
    }

    public void setBalanceBeforeTransactionTarget(Double balanceBeforeTransactionTarget) {
        this.balanceBeforeTransactionTarget = balanceBeforeTransactionTarget;
    }

    public Double getBalanceAfterTransactionSource() {
        return balanceAfterTransactionSource;
    }

    public void setBalanceAfterTransactionSource(Double balanceAfterTransactionSource) {
        this.balanceAfterTransactionSource = balanceAfterTransactionSource;
    }

    public Double getBalanceAfterTransactionTarget() {
        return balanceAfterTransactionTarget;
    }

    public void setBalanceAfterTransactionTarget(Double balanceAfterTransactionTarget) {
        this.balanceAfterTransactionTarget = balanceAfterTransactionTarget;
    }
}
