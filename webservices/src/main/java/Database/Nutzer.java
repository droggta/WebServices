package Database;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity
@Cacheable
public class Nutzer extends PanacheEntity {

    @Column(length = 40, unique = false)
    public String vorname;
    @Column(length = 40, unique = false)
    public String nachname;
    @Column(length = 40, unique = true)
    public String IBAN;
    @Column(length = 40, unique = false)
    public String BLZ;
    @Column(length = 40, unique = false)
    public double kontostand;
    @Column(length = 40, unique = false)
    public String strasse;
    @Column(length = 40, unique = false)
    public int hausnummer;
    @Column(length = 40, unique = false)
    public int PLZ;
    @Column(length = 40, unique = false)
    public String ort;

}