package nexa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Random;

public class PatientTest
{
    WebDriver driver;
    Random rnd =new Random();
    HashMap<String, String>hmap;

    @Test
    public void approvePatient()
    {
        WebDriverManager.chromedriver().setup();
        driver  = new ChromeDriver();
        driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/registration.php");
        RegistrationPage rp =new RegistrationPage(driver);
        String usernamevalue="karki"+(char) (65+rnd.nextInt(26));
        String passwordvalue="Karki"+ 100+rnd.nextInt(900);
        hmap=rp.registerPatient(usernamevalue, passwordvalue);
        String actual= hmap.get("successMessage");
        String expected= "Thank you for registering with MMP. ";
        Assert.assertEquals(actual,expected);
        driver.get("http://96.84.175.78/MMP-Release2-Admin-Build.2.1.000/login.php");
        AdminLogin al = new AdminLogin(driver);
        al.loginToAdmin("shreekarki", "Shreekarki100");
        HelperMethods helmperMethod = new HelperMethods(driver);
        helmperMethod.navigateToSubMenu("USer");
        AdminPage adminPage = new AdminPage(driver);
        adminPage.approvePatient(hmap);

        driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
        PatientLogin patientlogin= new PatientLogin(driver);
        patientlogin.login(usernamevalue, passwordvalue);
        actual = patientlogin.fetchUname().trim();
        expected = usernamevalue;

        Assert.assertEquals(actual, expected);







    }
}
