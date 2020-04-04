import Utilities.TestUtilDataProvider;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderMercuryTours
{
    @Test(dataProvider = "nexa")
    public void login(String username, String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("login")).click();
        driver.close();
    }

    @DataProvider(name="nexa")
    public Object[][]readExcel()
    {
        Object[][]input=TestUtilDataProvider.getTestData("Register");//read the excel data and sore in array object
        return input;

    }
}
