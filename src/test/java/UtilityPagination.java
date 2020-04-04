import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class UtilityPagination
{
    WebDriver driver;
    public UtilityPagination(WebDriver driver)

    {
        this.driver=driver;
    }
    public int a()
    {
        int i =10;
        return i;
    }
    public List<WebElement> retrieveSearchList(String searchText)
    {
        driver.findElement(By.id("header-search-input")).sendKeys(searchText);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        List<WebElement> searchList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li/span")));
        return searchList;
    }
    public boolean selectRequiredSearchPattern(String searchPattern)
    {
        boolean  result = false;
        WebDriverWait wait = new WebDriverWait(driver,10);
        List<WebElement> searchList = wait.until(ExpectedConditions.
                visibilityOfAllElementsLocatedBy(By.xpath("//ul[@role='listbox']/li/span")));
        for(int i=0;i<searchList.size();i++)
        {
            if(searchList.get(i).getText().contains(searchPattern))
            {
                searchList.get(i).click();
                result= true;
                break;
            }
        }
        return result;
    }
    public boolean validateLinkText(String searchPattern, int n,String title )
    {
        boolean result =true;
        List<WebElement> hLinkList=	driver.findElements(By.xpath("//div[@id='web']/ol/li//a"));
        for(int i=1;i<=n;i++)
        {
            System.out.println("****************Validating the Links in the Page ::: " + i+"****************************" );

            for(int j=0;j<hLinkList.size();j++)
            {
                System.out.println(hLinkList.get(j).getText().contains(searchPattern));
                if(!(hLinkList.get(j).getText().contains(searchPattern)))
                {
                    result = false;
                    System.out.println("The Link Text:::" + hLinkList.get(j).getText() +"   result:::" + result);
                }
            }

            focusonElement(driver.findElement(By.linkText((i+1)+"")));
            waitforTitle(title);
            hLinkList = driver.findElements(By.xpath("//div[@id='web']/ol/li//a"));
        }
        return result;
    }
    public void focusonElement(WebElement ele)
    {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",ele);
    }
    public void waitforTitle(String title)
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.titleContains(title));
    }


}
