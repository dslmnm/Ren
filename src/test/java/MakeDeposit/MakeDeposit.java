package MakeDeposit;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MakeDeposit {
    private WebDriver driver;
    private WebDriverWait wait;

    public MakeDeposit(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,2);
    }
    @FindBy(css="[href=\"/contributions/#section_6\"]")
    private WebElement depositPlus;

    @FindBy(css="[class=\"jq-checkbox calculator__check\"]")
    private WebElement calcCheck;

    @FindBy(css="[class=\"calculator__slide-input currency-input js-slide-value\"]")
    private WebElement summ;

    @FindBy(xpath="//span[@class='ui-slider-handle ui-state-default ui-corner-all']")
    private List<WebElement> sliderList;

    @Step(value = "Click +")
    public void clickPlus(){
        depositPlus.click();
    }
    @Step(value = "Click chkbx")
    public void inBankCheckBox(){
        calcCheck.click();
    }
    @Step(value = "Input summ {0}")
    public void inputSumm(String sum){
        summ.sendKeys(sum);
    }
    @Step(value = "Slide slider")
    public void slidePeriod(){
        WebElement draggable = sliderList.get(1);
        Actions actions=new Actions(driver);
        actions.dragAndDropBy(draggable,-300,0).perform();
    }
    @Step(value = "file download")
    public void downLoadRules()throws IOException {
        URL url = new URL("https://rencredit.ru/upload/iblock/02e/ou-po-vkladam-27.01.pdf");
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, Path.of(("C:\\JavaRushTasks\\autotest\\Ren\\src\\main\\resources\\rules.pdf")));
    }
}
