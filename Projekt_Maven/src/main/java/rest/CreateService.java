package rest;

import Database.Nutzer;
import Database.NutzerResource;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/create")
public class CreateService {

    @Inject
    NutzerResource userresource;

    @POST
    public Uni<Response> create(String recievername, String campus, String wohnort, String iban) {
        return null;
        //return userresource.create("{'recievername':'campus':'wohnort':'iban'}"9);
    }
}
