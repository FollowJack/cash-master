package model.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Deniel on 21.01.2015.
 */
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double balance;
    private String glyphIcon;
    private Date createOn;
    private Date modifiedOn;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "source")
    private List<BalanceSheetRecord> sourceRecord;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "target")
    private List<BalanceSheetRecord> targetRecord;

    public Account() {
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

    public List<BalanceSheetRecord> getSourceRecord() {
        return sourceRecord;
    }

    public void setSourceRecord(List<BalanceSheetRecord> sourceRecord) {
        this.sourceRecord = sourceRecord;
    }

    public List<BalanceSheetRecord> getTargetRecord() {
        return targetRecord;
    }

    public void setTargetRecord(List<BalanceSheetRecord> targetRecord) {
        this.targetRecord = targetRecord;
    }

    public String getGlyphIcon() {
        return glyphIcon;
    }

    public void setGlyphIcon(String glyphIcon) {
        this.glyphIcon = glyphIcon;
    }
}
