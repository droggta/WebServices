package Services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SOAPtest {
    public static void main(String args[]) throws IOException {

        String address="Hyderabad";

        /* place your xml request from soap ui below with necessary changes in parameters
        String xml="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://www.YourUrlAsPerWsdl.com/\">\r\n" +
                "   <soapenv:Header/>\r\n" +
                "   <soapenv:Body>\r\n" +
                "      <ws:callRest>\r\n" +
                "         <name>"+"Hello"+"</name>\r\n" +
                "         <address>"+address+"</address>\r\n" +
                "      </ws:callRest>\r\n" +
                "   </soapenv:Body>\r\n" +
                "</soapenv:Envelope>";
        */
        /*
        String xml="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:blz=\"http://thomas-bayer.com/blz/\">\n\r\n" +
                "   <soapenv:Header/>\r\n" +
                "   <soapenv:Body>\r\n" +
                "      <blz:getBank>\r\n" +
                "         <blz:blz>53093200</blz:blz>\r\n" +
                "      </blz:getBank>\r\n" +
                "   </soapenv:Body>\r\n" +
                "</soapenv:Envelope>";
*/
        String xml="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <tem:Add>\n" +
                "         <tem:intA>1</tem:intA>\n" +
                "         <tem:intB>2</tem:intB>\n" +
                "      </tem:Add>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        String responseF=callSoapService(xml);
        System.out.println(responseF);
    }


    static String callSoapService(String soapRequest) {
        try {
            //String url = "http://www.thomas-bayer.com/axis2/services/BLZService"; // replace your URL here
            //String url = "www.thomas-bayer.com"; // replace your URL here
            //String url = "http://www.thomas-bayer.com/axis2/services/BLZService HTTP/1.1\n"; // replace your URL here
            String url = "http://www.dneonline.com/calculator.asmx";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // change these values as per soapui request on top left of request, click on RAW, you will find all the headers
            con.setRequestMethod("POST");
            //con.setRequestProperty("application", "text/xml; charset=UTF-8");
            con.setRequestProperty("Content-Type", "text/xml; charset=UTF-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(soapRequest);
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

            // You can play with response which is available as string now:
            String finalvalue = response.toString();

            // or you can parse/substring the required tag from response as below based your response code
            finalvalue = finalvalue.substring(finalvalue.indexOf("<AddResult>")+11 , finalvalue.indexOf("</AddResult>"));//+Länge des öfnnenen Tags

            return finalvalue;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}


