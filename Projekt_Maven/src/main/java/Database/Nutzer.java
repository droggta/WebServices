package Database;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;

import io.quarkus.hibernate.reactive.panache.PanacheEntity;

@Entity
@Cacheable
public class Nutzer extends PanacheEntity {

    @Column(length = 40, unique = true)
    public String accountname;
    @Column(length = 40, unique = false)
    public String campus;
    @Column(length = 40, unique = false)
    public String wohnort;
    @Column(length = 40, unique = true)
    public String IBAN;
    @Column(length = 40, unique = false)
    public double kontostand;

    public static Nutzer findByName(String accountname){
        return (Nutzer) find("accountname", accountname).firstResult();
    }
}