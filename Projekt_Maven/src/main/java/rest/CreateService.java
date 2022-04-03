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

        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpPost request = new HttpPost(Configuration.instance.baseURL + "user");
            StringEntity params = new StringEntity("{\"recievername\":" + recievername + ",\"campus\":" + campus + ",\"wohnort\":" + wohnort + ",\"iban\":" + iban + "} ");
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }
}
