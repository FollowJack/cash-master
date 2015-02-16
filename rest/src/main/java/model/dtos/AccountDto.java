package model.dtos;

import model.entities.Account;

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
    private String glyphIcon;
    private Date createOn;
    private Date modifiedOn;

    private List<BalanceSheetRecordDto> records;

    public AccountDto() {
        records = new ArrayList<>();
    }


    public AccountDto(long id, String name, double balance,String glyphIcon) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.glyphIcon = glyphIcon;
    }

    public AccountDto(Account entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.balance = entity.getBalance();
        this.glyphIcon = entity.getGlyphIcon();

    }

    public void updateSource(Account entity) {
        entity.setCreateOn(this.getCreateOn());
        entity.setBalance(this.getBalance());
        entity.setName(this.getName());
        entity.setModifiedOn(this.getModifiedOn());
        entity.setGlyphIcon(this.getGlyphIcon());
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


    public String getGlyphIcon() {
        return glyphIcon;
    }

    public void setGlyphIcon(String glyphIcon) {
        this.glyphIcon = glyphIcon;
    }

    public List<BalanceSheetRecordDto> getRecords() {
        return records;
    }

    public void setRecords(List<BalanceSheetRecordDto> records) {
        this.records = records;
    }
}
