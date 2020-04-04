import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExcelDataMercuryTours
{
        static  WebDriver driver;

    public static void main(String[] args) throws IOException
    {

        WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
        driver.get("http://newtours.demoaut.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);





        FileInputStream file= new FileInputStream("D:\\Intellj_maven\\nexa_healcare\\src\\test\\Resources\\nexa_datadriven.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet("Register");
        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();
        for (int i=2;i<=rowCount;i++) {
            XSSFRow currentrow = sheet.getRow(i);//foucs on current row
            for (int j = 0; j < colCount; j++) {
                String value = currentrow.getCell(j).toString();//read the value from cell
                System.out.println(value);
                String userName= currentrow.getCell(0).toString();
                String password= currentrow.getCell(1).toString();
                driver.findElement(By.name("userName")).sendKeys(userName);
                driver.findElement(By.name("password")).sendKeys(password);
                driver.findElement(By.name("login")).click();
                driver.close();
            }
        }
    }

}
