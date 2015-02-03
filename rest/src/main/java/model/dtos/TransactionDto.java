package model.dtos;

import java.util.Date;

/**
 * Created by Deniel on 30.01.2015.
 */
public class TransactionDto {

    private long accountSourceId;
    private long accountTargetId;
    private String categoryName;
    private double amount;
    private Date targetMonth;
    private Date executionDate;
    private Date timeStamp;
    private String message;

    public TransactionDto(){
        timeStamp = new Date();
    }

    public long getAccountSourceId() {
        return accountSourceId;
    }

    public void setAccountSourceId(long accountSourceId) {
        this.accountSourceId = accountSourceId;
    }

    public long getAccountTargetId() {
        return accountTargetId;
    }

    public void setAccountTargetId(long accountTargetId) {
        this.accountTargetId = accountTargetId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
}
