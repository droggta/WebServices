package rest;

import Database.Nutzer;
import Database.NutzerResource;
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

        if(sender.kontostand >= amount){
            sender.kontostand -= amount;
            reciever.kontostand += amount;
            return "success";
        }
        else{
            return "ERROR: Kontostand nicht ausreichend";
        }
    }
}
