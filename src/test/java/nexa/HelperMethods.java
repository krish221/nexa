package nexa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class HelperMethods {
    WebDriver driver;

    public HelperMethods(WebDriver driver) {
        this.driver = driver;
    }
    public void navigateToSubMenu(String subMenuText)
    {
        // Method-1 Click on Sub menu for Schedule Appointment
        driver.findElement(By.xpath("//ul/li[@class='submenu']/a/span[contains(text(),'User')]")).click();

    }

}