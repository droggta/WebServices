package rest;

import Database.Nutzer;
import Database.NutzerResource;
import Services.ExternerRechenservice;
import io.smallrye.mutiny.Multi;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/transfer")
@RegisterRestClient
public class TransferService {
    @Inject
    NutzerResource userresource;

    @POST
    public String transfer(String recievername, String sendername, double amount) {
        Nutzer reciever = userresource.findByName(recievername);
        Nutzer sender = userresource.findByName(sendername);
        ExternerRechenservice rechner = new ExternerRechenservice();

        if(sender.kontostand >= amount){
            try {
                sender.kontostand = rechner.subtract(sender.kontostand, amount);
                reciever.kontostand = rechner.add(reciever.kontostand, amount);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return String.valueOf(sender.kontostand);
        }
        else{
            return "ERROR: Kontostand nicht ausreichend";
        }
    }
}
