import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class Base {

    WebDriver driver;

    @Test
    public void setUp() {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.manage().window().maximize();
        String url=driver.getCurrentUrl();
        System.out.println(url);
        System.out.println("page source");
       /* String page= driver.getPageSource();
        S*//*ystem.out.println(page);*/

        WebElement logo= driver.findElement(By.xpath("//div[@id='logo']"));
                logo.isDisplayed();

    }

    


    @AfterMethod

    public void tearDown(){


        driver.quit();
    }
}
