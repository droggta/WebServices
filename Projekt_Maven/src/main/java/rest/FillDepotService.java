package rest;

import Database.Nutzer;
import Database.NutzerResource;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/fill")
public class FillDepotService {
    @Inject
    NutzerResource userresource;
    @Inject
    Nutzer user;

    @POST
    public String fill(String recievername, double amount) {
        Nutzer reciever = user.findByName(recievername);
        reciever.kontostand += amount;
        return "success";
    }
}
