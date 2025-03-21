import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class SeleniumWebSignUpTest {
    private WebDriver driver;
@Test
    public void setUp() throws InterruptedException {
        //Locate where the chrome driver is
        System.setProperty("webdriver.chromedriver", "C:\\Users\\abdul\\Downloads\\FacebookTest\\FacebookTest\\resources\\chromedriver-win64\\chromedriver.exe");
        //1. Open Chrome browser
        driver = new ChromeDriver();
        //2. Input your selenium demo page URL https://selenium-blog.herokuapp.com/
        driver.get("https://selenium-blog.herokuapp.com/");
        Thread.sleep(5000);
        //3. Maximize the browser
        driver.manage().window().maximize();
        //4. Click on the signUp button to open the signup page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        //5. Input your username on the username field
        driver.findElement(By.id("user_username")).sendKeys("mide1");
        //6. Input your email address on the email address field
        driver.findElement(By.id("user_email")).sendKeys("mide1@gmail.com");
        //7. locate the password field and input your password
        driver.findElement(By.id("user_password")).sendKeys("p@ss");
        //8. Click on the signup button
        driver.findElement(By.id("submit")).click();
        //9. Click on user item on the list page
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/ul/div/div/li[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[1]/a")).click();
        //10. Search for an item (using python with selenium) and confirm it is present
        driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[1]/a")).click();
        //11. click on logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
    }

@AfterTest
    public void closeBrowser() {
        driver.quit();
        }

    }

