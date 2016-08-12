import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * Created by irina.bushinskaya on 8/11/2016.
 */

public class TestRun {

    private boolean acceptNextAlert = true;
    public static StringBuffer verificationErrors = new StringBuffer();
    public static String baseUrl;
    public static WebDriver driver;


    @BeforeClass
    public static void setUp() throws Exception {

        // Change path to chromedriver

         System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
        baseUrl = "http://www.tut.by";
        driver.manage().window().maximize();
    }


    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            System.out.println("Error");
        }
    }
}
