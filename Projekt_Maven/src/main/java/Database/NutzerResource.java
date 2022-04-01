package Database;

import Test.Fruit;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@Path("/user")
@ApplicationScoped
public class NutzerResource {
    @GET
    public Uni<List<Nutzer>> get() {
        return Nutzer.listAll(Sort.by("accountname"));
    }
}
