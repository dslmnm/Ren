import io.qameta.allure.*;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import GetCard.GetCard;
import MakeDeposit.MakeDeposit;

import java.io.IOException;

public class Tests extends WebDriverSettings {
    @Epic("Testing https://rencredit.ru/")
    @Feature(value = "Test 1")
    @Severity(value = SeverityLevel.MINOR)
    @Description("Input_form works correctly, file downloaded")
    @Story(value = "Makedoposit 500 000 rub + file download")
    @Test

    public void getDeposit() throws IOException {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        MakeDeposit makeDeposit=PageFactory.initElements(driver,MakeDeposit.class);

        homePage.open();
        makeDeposit.clickPlus();
        makeDeposit.inBankCheckBox();
        makeDeposit.inputSumm("500000");
        makeDeposit.slidePeriod();
        makeDeposit.downLoadRules();
    }
    @Epic("Testing https://rencredit.ru/")
    @Feature(value = "Test 2")
    @Severity(value = SeverityLevel.MINOR)
    @Description("Input_form works correctly")
    @Story(value = "Get credit card")
    @Test

    public void getCard(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        MakeDeposit makeDeposit=PageFactory.initElements(driver,MakeDeposit.class);
        GetCard getCard=PageFactory.initElements(driver,GetCard.class);

        homePage.open();
        getCard.open();
        getCard.card365();
        getCard.entFName("Пётр");
        getCard.entLName("Иванов");
        getCard.entTel("9090022032");
        getCard.entMail("inan@mail.ru");
        getCard.chkbox();
        getCard.selectPlace();
        getCard.selectCity();
    }


}
