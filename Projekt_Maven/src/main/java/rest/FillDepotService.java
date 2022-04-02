package rest;

import Database.Nutzer;
import Database.NutzerResource;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/fill")
@RegisterRestClient
public class FillDepotService {
    @Inject
    NutzerResource userresource;

    @POST
    public String fill(String recievername, double amount) {
        Nutzer reciever = userresource.findByName(recievername);
        reciever.kontostand += amount;
        return "success";
    }
}
