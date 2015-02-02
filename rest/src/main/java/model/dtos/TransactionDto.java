package model.dtos;

import java.util.Date;

/**
 * Created by Deniel on 30.01.2015.
 */
public class TransactionDto {

    private long accountSourceId;
    private long targetId;
    private String categoryName;
    private double amount;
    private Date timeStamp;
    private String message;

    public long getAccountSourceId() {
        return accountSourceId;
    }

    public void setAccountSourceId(long accountSourceId) {
        this.accountSourceId = accountSourceId;
    }

    public long getTargetId() {
        return targetId;
    }

    public void setTargetId(long targetId) {
        this.targetId = targetId;
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
}
