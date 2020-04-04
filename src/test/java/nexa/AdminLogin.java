package nexa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminLogin
{
    WebDriver driver;

    public AdminLogin(WebDriver driver) {
        this.driver=driver;
    }

    public void loginToAdmin(String username, String passwrod)
    {
        driver.findElement(By.name("username")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(passwrod);
        driver.findElement(By.name("admin")).click();



    }
}
