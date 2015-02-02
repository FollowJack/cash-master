package model.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Deniel on 21.01.2015.
 */
public class AccountDto {

    private long id;
    private String name;
    private double balance;
    private Date createOn;
    private Date modifiedOn;

    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "source")
    private List<BalanceSheetRecordDto> sourceRecord;
    //@OneToMany(cascade = CascadeType.ALL, mappedBy = "target")
    private List<BalanceSheetRecordDto> targetRecord;

    public AccountDto() {
        sourceRecord = new ArrayList<>();
        targetRecord = new ArrayList<>();
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getCreateOn() {
        return createOn;
    }

    public void setCreateOn(Date createOn) {
        this.createOn = createOn;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public void setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
    }
}
