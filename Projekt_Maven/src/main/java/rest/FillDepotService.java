package rest;

import Database.Nutzer;
import Database.NutzerResource;
import Services.ExternerRechenservice;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.reactive.RestHeader;
import org.jboss.resteasy.reactive.RestQuery;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.xml.ws.Response;

@Path("/fill")
@RegisterRestClient
public class FillDepotService {
    @Inject
    NutzerResource userresource;

    @POST
    public String fill(String recievername, double amount) {
        Nutzer reciever = userresource.findByName(recievername);
        ExternerRechenservice rechner = new ExternerRechenservice();

        try {
            reciever.kontostand = rechner.add(reciever.kontostand, amount);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }
}
