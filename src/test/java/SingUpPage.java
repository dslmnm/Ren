import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.util.List;

public class SingUpPage {

    WebDriver driver;
    WebDriverWait wait;

    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public void open() throws IOException {
        driver.get("https://rencredit.ru/");
        //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"service__title\"]")));
        driver.findElement(By.cssSelector("[href=\"/contributions/#section_6\"]")).click();
        driver.findElement(By.cssSelector("[class=\"jq-checkbox calculator__check\"]")).click();
        driver.findElement(By.cssSelector("[class=\"calculator__slide-input currency-input js-slide-value\"]")).sendKeys("500000");

        List<WebElement> list=driver.findElements(By.xpath("//span[@class='ui-slider-handle ui-state-default ui-corner-all']"));
        WebElement draggable = list.get(1);

        Actions actions=new Actions(driver);
        actions.dragAndDropBy(draggable,-300,0).perform();


        URL url = new URL("https://rencredit.ru/upload/iblock/02e/ou-po-vkladam-27.01.pdf");
        InputStream inputStream = url.openStream();
        Files.copy(inputStream, new File("C:/Users/admin/Ren/src/main/resources.pdf").toPath());

    }

}
