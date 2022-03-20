package Services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class Prototype4 {
    public static void main(String[] args) {
        String url = "http://www.dneonline.com/calculator.asmx";
        final Client client = ClientBuilder.newClient();
        WebTarget wt = client.target(url).queryParam("appid");

        // initCache();
    }
}
