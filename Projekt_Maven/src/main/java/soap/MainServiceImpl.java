package soap;

import javax.jws.WebService;

@WebService(name = "main", serviceName = "mainService")
public class MainServiceImpl implements MainService{
    @Override
    public String test(final String testData) {
        return null;
    }
}
