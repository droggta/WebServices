package Services;

public class ExternerRechenservice extends ExternService {


    public ExternerRechenservice() {
        super("http://www.dneonline.com/calculator.asmx");
    }

    public double add(double a, double b) throws Exception {
        int intA = (int) (a * 100);
        int intB = (int) (b * 100);
        String xml = generateXML(intA, intB, "Add");
        String result = send(xml, "POST", "Content-Type", "text/xml; charset=UTF-8");
        return (double) Integer.parseInt(getResultField(result, "AddResult")) / 100;
    }

    public double subtract(double a, double b) throws Exception {
        int intA = (int) (a * 100);
        int intB = (int) (b * 100);
        generateXML(intA, intB, "Subtract");
        String xml = generateXML(intA, intB, "Subtract");
        String result = send(xml, "POST", "Content-Type", "text/xml; charset=UTF-8");
        return (double) Integer.parseInt(getResultField(result, "SubtractResult")) / 100;
    }

    private String generateXML(int a, int b, String methode) {
        String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <tem:" + methode + ">\n" +
                "         <tem:intA>" + a + "</tem:intA>\n" +
                "         <tem:intB>" + b + "</tem:intB>\n" +
                "      </tem:" + methode + ">\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";
        return xml;
    }
}
