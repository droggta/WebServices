package Database;

import io.quarkus.hibernate.reactive.panache.Panache;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.List;

@Path("/user")
@ApplicationScoped
@RegisterRestClient
public class NutzerResource {
    @GET
    public Uni<List<Nutzer>> get() {
        return Nutzer.listAll(Sort.by("accountname"));
    }

    @GET
    @Path("/getSingle/{id}")
    public Uni<Nutzer> getSingle(Long id) {
        return Nutzer.findById(id);
    }

    @POST
    public Uni<Response> create(Nutzer nutzer) {
        return Panache.<Nutzer>withTransaction(nutzer::persist)
                .onItem().transform(inserted -> Response.created(URI.create("/user/" + inserted.id)).build());
    }

    @GET
    @Path("/findbyName/{accountname}")
    public Uni<Nutzer> findByName(String accountname){
        return Nutzer.find("accountname", accountname).firstResult();
    }
}
