import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings{
    public ChromeDriver driver;
    //public WebDriverWait wait;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1500,1500));
        //wait=new WebDriverWait(driver,10);
    }
    @After
    public void close(){
        //driver.quit();
    }
}
