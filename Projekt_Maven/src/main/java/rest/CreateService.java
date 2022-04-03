package rest;

import Database.NutzerResource;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/create")
@RegisterRestClient
public class CreateService {

    @Inject
    NutzerResource userresource;

    @POST
    public String create(String recievername, String campus, String wohnort, String iban) {

        return userresource.create(recievername, campus, wohnort, iban);

    }
}
