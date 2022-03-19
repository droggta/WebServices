package Services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class ExternService {
    protected final String url;

    public ExternService(String url) {
        this.url = url;
    }

    protected String send(String body, String methode, String type, String meta) throws Exception {

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod(methode);
        con.setRequestProperty(type, meta);
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(body);
        wr.flush();
        wr.close();
        String responseStatus = con.getResponseMessage();
        System.out.println(responseStatus);
        BufferedReader in = new BufferedReader(new InputStreamReader(
                con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }

    protected String getResultField(String xml, String seperator) {
        String result = xml.substring(xml.indexOf("<" + seperator + ">") + (2 + seperator.length()), xml.indexOf("</" + seperator + ">"));//+Länge des öfnnenen Tags

        return result;
    }

}
