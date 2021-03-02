package GetCard;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GetCard {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(css="[href=\"/cards/\"]")
    WebElement openCards;

    @FindBy(css="[href=\"https://rencredit.ru/app/card/365\"]")
    WebElement enterOnCard;

    @FindBy(xpath="//input[@class='animate-input required ConvertToRussian CompareNamesSurname russianLettersFIO eSymbolReplacement']")
    WebElement lastName;

    @FindBy(css="[data-message-title=\"Имя\"]")
    WebElement firstName;

    @FindBy(xpath="//input[@class='animate-input phone-check-first phone-check-second required js-phone-input Telephone']")
    WebElement tel;

    @FindBy(xpath="//input[@name=\"AdditionalEmail\"]")
    WebElement email;

    @FindBy(xpath="//div[@class=\"jq-checkbox js-validation-ignore-checkbox\"]")
    WebElement checkBox;

    @FindBy(css="[class=\"jq-selectbox__select-text placeholder\"]")
    WebElement placeHolder;

    @FindBy(xpath = "//li[contains(text(),'г. Москва')]")
    WebElement moscow;




    public GetCard(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver,2);
    }
    @Step(value = "OpenSite")
    public void open(){
        openCards.click();
    }
    @Step(value = "365CardClick")
    public void card365(){
        enterOnCard.click();
    }
    @Step(value = "Enter fName {0}")
    public void entFName(String Fname){
        firstName.sendKeys(Fname);
    }
    @Step(value = "Enter lName {0}")
    public void entLName(String Lname){
        lastName.sendKeys(Lname);
    }
    @Step(value = "Enter Tel {0}")
    public void entTel(String telnumb){
        tel.sendKeys(telnumb);
    }
    @Step(value = "Enter email {0}")
    public void entMail(String mail){
        email.sendKeys(mail);
    }
    @Step(value = "chkbox")
    public void chkbox(){
        checkBox.click();
    }
    @Step(value = "selectplace")
    public void selectPlace(){
        placeHolder.click();
    }
    @Step(value = "selectplace")
    public void selectCity(){
        moscow.click();

        WebElement selectElem = driver.findElement(By.xpath("//select[@class=\"required animate-input\"]"));
        Select select = new Select(selectElem);
        select.selectByIndex(1);
    }

}
