package rest;

import Database.NutzerResource;
import configuration.Configuration;
import io.smallrye.mutiny.Uni;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/create")
@RegisterRestClient
public class CreateService {

    @Inject
    NutzerResource userresource;

    @POST
    public Uni<Response> create(String recievername, String campus, String wohnort, String iban) {

        userresource.create(recievername, campus, wohnort, iban);

        return null;
    }
}
