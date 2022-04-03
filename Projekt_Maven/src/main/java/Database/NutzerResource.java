package Database;

import Services.ExternerBLZKonverter;
import configuration.Configuration;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Path("/user")
@RegisterRestClient
public class NutzerResource{

    @GET
    @Path("/create")
    public String create(String accountname, String campus, String wohnort, String iban) {
        Nutzer user = new Nutzer();
        user.setId(Configuration.instance.users.stream().count());
        user.setAccountname(accountname);
        user.setCampus(campus);
        user.setWohnort(wohnort);
        user.setIBAN(iban);
        char[] ibanarray = iban.toCharArray();
        String blz = "";
        for (int i = 0; i < 8; i++){
            blz += ibanarray[i+4];
        }
        user.setBLZ(blz);
        ExternerBLZKonverter blzKonverter = new ExternerBLZKonverter();
        try {
            user.setBank(blzKonverter.getBLZInfos(Integer.getInteger(blz)));
        } catch (Exception e) {

        }
        Configuration.instance.users.add(user);
        return user.getAccountname();
    }

    @GET
    @Path("/findbyName/{name}")
    public Nutzer findByName(String name){
        for(Nutzer user : Configuration.instance.users){
            if(user.getAccountname() != null && user.getAccountname().equals(name)) {
                return user;
            }
        }
        return null;
    }
}
