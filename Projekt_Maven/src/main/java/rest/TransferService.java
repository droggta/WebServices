package rest;

import Database.Nutzer;
import Database.NutzerResource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/transfer")
public class TransferService {
    @Inject
    NutzerResource userresource;
    @Inject
    Nutzer user;

    @POST
    public String transfer(String recievername, String sendername, double amount) {
        Nutzer reciever = user.findByName(recievername);
        Nutzer sender = user.findByName(sendername);

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
