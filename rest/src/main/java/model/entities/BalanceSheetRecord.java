package model.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Deniel on 21.01.2015.
 */
@Entity
public class BalanceSheetRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Double transferAmount;
    private Date targetMonth;
    private Date executionDate;
    private Date createdOn;
    private Date modifiedOn;
    private Double balanceBeforeTransactionSource;
    private Double balanceBeforeTransactionTarget;
    private Double balanceAfterTransactionSource;
    private Double balanceAfterTransactionTarget;

    @ManyToOne
    private Category category;
    @ManyToOne
    private Account source;
    @ManyToOne
    private Account target;

    public BalanceSheetRecord(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getTargetMonth() {
        return targetMonth;
    }

    public void setTargetMonth(Date targetMonth) {
        this.targetMonth = targetMonth;
    }

    public Date getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Date executionDate) {
        this.executionDate = executionDate;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Account getSource() {
        return source;
    }

    public void setSource(Account source) {
        this.source = source;
    }

    public Account getTarget() {
        return target;
    }

    public void setTarget(Account target) {
        this.target = target;
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
