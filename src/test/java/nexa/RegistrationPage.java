package nexa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class RegistrationPage
{
    HashMap<String, String>hmap = new HashMap<String, String>();
    Random rnd = new Random();
    WebDriver driver;
    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public HashMap<String, String> registerPatient(String uname, String  pword)
    {
        WebElement firstNameTxField = driver.findElement(By.id("firstname"));
        String fNameValue="shree" + (char)(65 + rnd.nextInt(26));
        firstNameTxField .sendKeys(fNameValue);
        hmap.put("firstname",firstNameTxField.getAttribute("value"));

        WebElement lastNameTxField = driver.findElement(By.id("lastname"));
        lastNameTxField.sendKeys("karki");
        hmap.put("lastname",lastNameTxField.getAttribute("value"));

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
        Date d = new Date();
        Calendar c = Calendar.getInstance();
        c.add(Calendar.YEAR, -30);
        c.add(Calendar.MONTH, 2);
        c.add(Calendar.DAY_OF_MONTH, 5);
        String dob = sdf.format(c.getTime());

        WebElement DOBTextField=driver.findElement(By.id("datepicker"));
        DOBTextField.sendKeys((dob));
        hmap.put("datepicker", DOBTextField.getAttribute("Value"));

        WebElement licenseTextField=driver.findElement(By.id("license"));
        long licenseValue=10000000+rnd.nextInt(90000000);
        licenseTextField.sendKeys("12345678");
        hmap.put("licenseValue", licenseTextField.getAttribute("Value"));

        WebElement ssnTextField = driver.findElement(By.id("ssn"));
        int ssnValue = 100000000+rnd.nextInt(900000000);
        ssnTextField.sendKeys(""+ssnValue);
        hmap.put("ssnValue",ssnTextField.getAttribute("value"));

        WebElement stateTxtField = driver.findElement(By.id("state"));
        stateTxtField.sendKeys("New York");
        hmap.put("state", stateTxtField.getAttribute("value"));

        WebElement cityTxtField = driver.findElement(By.id("city"));
        cityTxtField.sendKeys("seattle");
        hmap.put("city", cityTxtField.getAttribute("value"));

        WebElement addressTxtField = driver.findElement(By.id("address"));
        addressTxtField.sendKeys("10 street");
        hmap.put("address", addressTxtField.getAttribute("value"));

        WebElement zipcodeTxtField = driver.findElement(By.id("zipcode"));
        long zipValue = 10000+rnd.nextInt(90000);
        zipcodeTxtField.sendKeys(""+zipValue);
        hmap.put("zipcode", zipcodeTxtField.getAttribute("value"));

        WebElement ageTxtField = driver.findElement(By.id("age"));
        long ageValue = 10+rnd.nextInt(90);
        ageTxtField.sendKeys(""+ageValue);
        hmap.put("age", ageTxtField.getAttribute("value"));

        WebElement heightTxtField = driver.findElement(By.id("height"));
        heightTxtField.sendKeys("50");
        hmap.put("height", heightTxtField.getAttribute("value"));

        WebElement weightTxtField = driver.findElement(By.id("weight"));
        weightTxtField.sendKeys("50");
        hmap.put("weight", weightTxtField.getAttribute("value"));

        WebElement emailTxtField = driver.findElement(By.id("email"));
        String emailValue = "testEmail" +  (char) (65+rnd.nextInt(26))+"@gmail.com";
        emailTxtField.sendKeys(emailValue );
        hmap.put("email", emailTxtField.getAttribute("value"));

        WebElement userNameTxtField = driver.findElement(By.id("username"));
        String username="karki"+(char) (65+rnd.nextInt(26));
        userNameTxtField.sendKeys(uname);//passing string
        hmap.put("username", userNameTxtField.getAttribute("Value"));

        WebElement PasswordTxtField = driver.findElement(By.id("password"));
        String password="Karki"+ 100+rnd.nextInt(900);
        PasswordTxtField.sendKeys(pword);// passing string
        hmap.put("password", PasswordTxtField.getAttribute("Value"));

        WebElement confirmPassWordTxtField = driver.findElement(By.id("confirmpassword"));
        confirmPassWordTxtField.sendKeys(pword);
        hmap.put("confirmPassWord", confirmPassWordTxtField.getAttribute("Value"));

        new Select(driver.findElement(By.id("security"))).selectByVisibleText("what is your best friend name");

        WebElement answerTxtField = driver.findElement(By.id("answer"));
        answerTxtField.sendKeys("Ram");
        hmap.put("answer",answerTxtField.getAttribute("Value"));

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        String successMessage = driver.switchTo().alert().getText();
        System.out.println(successMessage);
        hmap.put("successMessage", successMessage);
        driver.switchTo().alert().accept();
        Assert.assertEquals(successMessage, "Thank you for registering with MMP. ");

        return hmap;
    }

}


