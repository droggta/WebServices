package soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL,
parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface MainService {

    @WebMethod
    @WebResult(name = "Success")
    String getData(@WebParam(name = "callmethod")  @XmlElement(required = true) String callmethod,
                   @WebParam(name = "recievername")  @XmlElement(required = true) String recievername,
                   @WebParam(name = "sendername")  @XmlElement(required = true) String sendername,
                   @WebParam(name = "amount")  @XmlElement(required = true) double amount,
                   @WebParam(name = "Campus")  @XmlElement(required = true) String campus,
                   @WebParam(name = "Wohnort")  @XmlElement(required = true) String wohnort,
                   @WebParam(name = "iban")  @XmlElement(required = true) String iban);

    @WebMethod
    @WebResult(name = "test")
    String testreturn();
}
