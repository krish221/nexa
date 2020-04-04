import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class pagination {
    WebDriver driver;


    @Test
    public void validateSearchResults() {
        SoftAssert sa = new SoftAssert();
        System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.yahoo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        UtilityPagination up=new UtilityPagination(driver);
        List<WebElement> list =  up.retrieveSearchList("selenium");
        up.selectRequiredSearchPattern("selenium interview questions");
        up.validateLinkText("selenium interview questions",5,"selenium");


    }
}