package Services;

public class ExternerBLZKonverter extends ExternService {
    public ExternerBLZKonverter() {
        super("http://www.thomas-bayer.com/axis2/services/BLZService");
    }

    public BankInfo getBLZInfos(int blz) throws Exception {

        String xml = "<soap:Envelope xmlns:soap=\"http://www.w3.org/2003/05/soap-envelope\" xmlns:blz=\"http://thomas-bayer.com/blz/\">\n" +
                "   <soap:Header/>\n" +
                "   <soap:Body>\n" +
                "      <blz:getBank>\n" +
                "         <blz:blz>" + blz + "</blz:blz>\n" +
                "      </blz:getBank>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";
        String result = send(xml, "POST", "Content-Type", "application/soap+xml; charset=UTF-8");
        String description = getResultField(result, "ns1:bezeichnung");
        String bic = getResultField(result, "ns1:bic");
        String city = getResultField(result, "ns1:ort");
        String plz = getResultField(result, "ns1:plz");

        return new BankInfo(description, bic, city, Integer.parseInt(plz));

    }

    public static void main(String[] args) {
        try {
            ExternerBLZKonverter kon = new ExternerBLZKonverter();
            System.out.println(kon.getBLZInfos(53093200).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
