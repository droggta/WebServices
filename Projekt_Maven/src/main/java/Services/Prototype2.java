package Services;

import org.apache.soap.Constants;
import org.apache.soap.Fault;
import org.apache.soap.SOAPException;
import org.apache.soap.rpc.Call;
import org.apache.soap.rpc.Parameter;
import org.apache.soap.rpc.Response;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Vector;


public class Prototype2 {
/*
    public static void main(String[] args) throws MalformedURLException, SOAPException {
        // Erzeugen des Aufruf-Objekts
        Call call = new Call(  );
        call.setTargetObjectURI("getBankResponse");
        call.setMethodName("getBank");
    //    call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
        String nsUriSoapEnc = Constants.NS_URI_SOAP_ENC;

       // String ns_uri="http://schemas.xmlsoap.org/soap/encoding/";
        call.setEncodingStyleURI(nsUriSoapEnc);

        // Setzen der Parameter
        Vector params = new Vector(  );
        params.addElement(new Parameter("blz", String.class, "53093200", null));
        call.setParams(params);

        // Aufrufen
        Response response;
       // response = call.invoke(new URL("http://thomas-bayer.com"), "");http://www.thomas-bayer.com/axis2/services/BLZService
       // response = call.invoke(new URL("http://www.thomas-bayer.com/axis2/services/BLZService"), "");
        response = call.invoke(new URL("http://www.thomas-bayer.com/axis2/services/BLZService?wsdl"), "");
        //response = call.invoke(new URL("http://www.thomas-bayer.com/axis2/services"), "");

        if (!response.generatedFault(  )) {
            Parameter returnValue = response.getReturnValue(  );
            System.out.println("Erfolg");
        } else {
            Fault fault = response.getFault(  );
            System.out.println("Fehler: " + fault.getFaultString(  ));
        }
        System.out.println("ende");
    }
*/

    public static void main(String[] args) throws MalformedURLException, SOAPException {
        // Erzeugen des Aufruf-Objekts
        Call call = new Call();
        //call.setTargetObjectURI("Add");
        //call.setMethodName("http://tempuri.org/Add");
        //call.setTargetObjectURI("http://tempuri.org/Add");
        //call.setTargetObjectURI("http://schemas.xmlsoap.org/soap/http");
        //call.setMethodName("http://tempuri.org/Add");
        call.setTargetObjectURI("CalculatorSoap");
        call.setMethodName("Add");


        //    call.setEncodingStyleURI(Constants.NS_URI_SOAP_ENC);
        String nsUriSoapEnc = Constants.NS_URI_SOAP_ENC;

        // String ns_uri="http://schemas.xmlsoap.org/soap/encoding/";
        call.setEncodingStyleURI(nsUriSoapEnc);

        // Setzen der Parameter
        Vector params = new Vector();
        params.addElement(new Parameter("intA", Integer.class, 1, null));
        params.addElement(new Parameter("intB", Integer.class, 2, null));
        call.setParams(params);

        // Aufrufen
        Response response;
        // response = call.invoke(new URL("http://thomas-bayer.com"), "");http://www.thomas-bayer.com/axis2/services/BLZService
        // response = call.invoke(new URL("http://www.thomas-bayer.com/axis2/services/BLZService"), "");
        response = call.invoke(new URL("http://www.dneonline.com/calculator.asmx"), "");
        //response = call.invoke(new URL("http://www.thomas-bayer.com/axis2/services"), "");

        if (!response.generatedFault()) {
            Parameter returnValue = response.getReturnValue();
            System.out.println("Erfolg");
        } else {
            Fault fault = response.getFault();
            System.out.println("Fehler: " + fault.getFaultString());
        }
        System.out.println("ende");

    }


}

