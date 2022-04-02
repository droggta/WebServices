package soap;

import com.fasterxml.jackson.annotation.JsonInclude;
import rest.CreateService;
import rest.FillDepotService;
import rest.TransferService;

import javax.inject.Inject;
import javax.jws.WebService;

@WebService(endpointInterface = "soap.MainService")
public class MainServiceImpl implements MainService{

    @Inject
    CreateService createService;
    @Inject
    FillDepotService fillService;
    @Inject
    TransferService transferService;

    @Override
    public String getData(String callmethod, String recievername, String sendername, double amount, String campus, String wohnort, String iban) {

        switch(callmethod){
            case "create":
                if (recievername != null && campus != null && wohnort != null && iban != null){
                    createService.create(recievername, campus, wohnort, iban);
                }
                else {
                    return "missing input";
                }
                break;
            case "transfer":
                if (recievername != null && sendername != null && amount > 0){
                    transferService.transfer(recievername, sendername, amount);
                }
                else {
                    return "missing input";
                }
                break;
            case "filldepot":
                if (recievername != null && amount > 0){

                }
                else {
                    return "missing input";
                }
                break;
        }

        return "success";
    }

    @Override
    public String testreturn() {
        return "Hi das hat funktioniert";
    }
}
