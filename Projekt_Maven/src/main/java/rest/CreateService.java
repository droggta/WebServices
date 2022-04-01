package rest;

import Database.Nutzer;
import Database.NutzerResource;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;

@Path("/create")
public class CreateService {

    @POST
    public Uni<Response> create(Nutzer nutzer) {
        
    }
}
