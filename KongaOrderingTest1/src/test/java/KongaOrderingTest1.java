import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class KongaOrderingTest1 {

    //import the selenium WebDriver
    private WebDriver driver;

@BeforeTest
    public void main() throws InterruptedException {
    //Locate where the chromedriver is
    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
    //1. Open your chrome browser
    driver = new ChromeDriver();

    //2. Input your URL
    driver.get("https://www.konga.com/");

    //3. Maximize page
    driver.manage().window().maximize();

    //4. Click on the login button to open the login page
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div[4]/a")).click();
    Thread.sleep(5000);

    //5. Input your email on the email field
    driver.findElement(By.id("username")).sendKeys("");
    //6. Input your password on the password field
    driver.findElement(By.id("password")).sendKeys("");

    //7. Click on the login button
    driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
    Thread.sleep(10000);

    //8. Click the Categories
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[1]")).click();
    Thread.sleep(10000);

    //click on the “Computers and Accessories
    driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
    Thread.sleep(10000);

    //9.  Click on the Laptop SubCategory
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
    Thread.sleep(10000);

    //10. Click on the Apple MacBooks
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/div/section/div[2]/div[2]/ul/li[3]/a/ul/li[1]/a/label/span")).click();
    Thread.sleep(10000);

    //11. Click on an item
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[1]/section/section/section/section/section/ul/li[8]/article/div[2]/a/h3")).click();
    Thread.sleep(10000);

    //Click on add to cart
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[4]/div[3]/div[1]/div[1]/div/div[2]/div[2]/form/div[5]/div[1]/button")).click();
    Thread.sleep(10000);


    //Click on the continue to checkout
    //driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div[3]/div/div[2]/a")).click();
    WebElement element = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/div[2]/div[3]/div[3]/div/div[2]/a"));
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);
    Thread.sleep(10000);

    //Click on Pay now
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/span/input")).click();
    Thread.sleep(10000);

       //13. Continue to make payment
    driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
    Thread.sleep(10000);

    //switch to iframe
    WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"kpg-frame-component\"]"));
    driver.switchTo().frame(iframeElement);
    Thread.sleep(10000);

    //switch to iframe
    //driver.switchTo().frame("kpg-frame-component-container");
    //Thread.sleep(5000);

    //click on card
    WebElement cardButton = driver.findElement(By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[3]"));
    cardButton.click();
    Thread.sleep(3000);

    // enter wrong card detail
    driver.findElement(By.id("card-number")).sendKeys("4920690182556718");
    Thread.sleep(10000);


    //Locate error message invalid card number
    WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"card-number\"]"));
    Thread.sleep(10000);

    // print error message
    System.out.println("Error Message: " + errorMsg.getText());
    Thread.sleep(10000);


    //print error message invalid card number
    //WebElement errorMsg = driver.findElement(By.id("card-number_unhappy"));
    //System.out.println("Error Message: " + errorMsg.getText());
    //Thread.sleep(10000);
    // //*[@id="card-number_unhappy"]

    // close frame
    //driver.findElement(By.xpath("//*[@id=\"kpg-frame-component\"]")).click();
    driver.switchTo().defaultContent();
    Thread.sleep(10000);

    }

    @AfterTest
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser closed successfully.");
        } else {
            System.out.println("Driver was not initialized. Browser not closed.");
        }
    }
}