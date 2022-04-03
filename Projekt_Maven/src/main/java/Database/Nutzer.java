package Database;

import Services.BankInfo;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.inject.Inject;
import javax.persistence.*;

public class Nutzer{

    private Long id;
    public String accountname;
    public String campus;
    public String wohnort;
    public String IBAN;
    public String BLZ;
    public double kontostand;
    public BankInfo bank;

    public BankInfo getBank() {
        return bank;
    }

    public void setBank(BankInfo bank) {
        this.bank = bank;
    }

    public String getBLZ() {
        return BLZ;
    }

    public void setBLZ(String BLZ) {
        this.BLZ = BLZ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountname() {
        return accountname;
    }

    public void setAccountname(String accountname) {
        this.accountname = accountname;
    }

    public String getCampus() {
        return campus;
    }

    public void setCampus(String campus) {
        this.campus = campus;
    }

    public String getWohnort() {
        return wohnort;
    }

    public void setWohnort(String wohnort) {
        this.wohnort = wohnort;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public double getKontostand() {
        return kontostand;
    }

    public void setKontostand(double kontostand) {
        this.kontostand = kontostand;
    }

    public Nutzer() {
    }

}