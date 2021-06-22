import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableWithPagination {


    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://demo.opencart.com");

        //this is using to find how many pages are there in a table list

        //Table bottom total pages shown
        String text = driver.findElement(By.xpath("text")).getText();
        //to split the total pages written

        int totalPages = Integer.valueOf(text.substring(text.indexOf("(") + 1, text.indexOf("pages") - 1));
        System.out.println(totalPages);
        //xpath is dynamic. active page is showing as active span, normal page is showing as link
        for (int i = 1; i <= totalPages; i++) {
            WebElement activePage = driver.findElement(By.xpath("hereweareusingdynamicxpath"));
            System.out.println("Active page is : " + activePage);
            activePage.click();
            //to check total no. of rows in a page
            int rows = driver.findElements(By.xpath("xpathOfFullRows")).size();
            System.out.println("total rows in a page " + rows);

            String pageNumber = Integer.toString(i + 1);//because page 1 by default active
            //dynamic xpath
            driver.findElement(By.xpath("//ul[@Class='pagination']//li//a[text()='" + pageNumber + "']")).click();

            for (int r = 1; r <= rows; r++) {
                String orderid =
                        driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[2]")).getText();

                String customerName =
                        driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//" +
                                "tr[" + r + "]//td[3]")).getText();

                String status =
                        driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr[" + r + "]//td[4]")).getText();

                if (status.equals("Pending"))
                    System.out.println("pending details are " + orderid + " ," + customerName + status);
            }

        }


    }


}
