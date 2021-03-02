import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class SingUp extends WebDriverSettings{
    @Test
    public void SingUp() throws IOException {
        SingUpPage singUpPage= PageFactory.initElements(driver,SingUpPage.class);
        singUpPage.open();
    }
}
