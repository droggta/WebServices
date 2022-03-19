import Services.ExternerRechenservice;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestExtern {
    private ExternerRechenservice rechenservice;
    @BeforeEach
    public void setup() {
       rechenservice=new ExternerRechenservice();
    }

    @Test
    @Order(1)
    public void buildComplete() {
        assertNotNull(rechenservice);
    }

    @Test
    @Order(2)
    public void add() {
        try {
            assertEquals(10,rechenservice.add(5.75, 4.25));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    @Order(3)
    public void sub() {
        try {
            assertEquals(1.5,rechenservice.add(5.75, 4.25));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
