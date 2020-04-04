package nexa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class AdminPage
{
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver=driver;
    }

    public void approvePatient(HashMap<String, String>hmap)
    {
        Select patientStatus= new Select(driver.findElement(By.id("search")));
        patientStatus .selectByVisibleText("Pending");
        driver.findElement(By.xpath("//a[contains(text(),'"+hmap.get("firstname")+"')]"));//patient first name is fetched from the registration page
        Select approvePatient= new Select(driver.findElement(By.id("sapproval")));
        approvePatient.selectByVisibleText("Accepted");
        driver.findElement(By.xpath("//input[@value='Submit']"));
    }
}
