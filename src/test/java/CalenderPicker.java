import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CalenderPicker {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://redbus.com");
        driver.manage().window().maximize();

        String month = "Aug";
        String year = "2021";
        String date = "15";

        driver.findElement(By.id("onward_cal")).click();

        while (true) {

            String monthYear = driver.findElement(By.id("monthTitle")).getText();
            String arr[] = monthYear.split(" ");
            String mon;
            mon = arr[0];
            String yr = arr[1];

            if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year))
                break;
            else
                driver.findElement(By.xpath("//button[@id='click']")).click();
        }

        List<WebElement> datelist = driver.findElements(By.xpath("//id"));

        for (WebElement element: datelist){
            String dt = element.getText();
            if (dt.equalsIgnoreCase(date)){
                element.click();
                break;
            }
        }

//Second type of Calendar

        /*
        in this calender we have to use dropdown so that using Select class

         */
        Select selectMonth= new Select(driver.findElement(By.xpath("id")));
        selectMonth.selectByVisibleText("oct");
        Select selectYear= new Select(driver.findElement(By.id("year")));
        selectYear.selectByVisibleText("2000");

        String clickDate = "15";

        List<WebElement> allDates= driver.findElements(By.xpath("test"));

        for(WebElement ele : allDates){
            String dt= ele.getText();
            if(dt.equals(clickDate)){
                ele.click();
                break;
            }


        }







    }
}
