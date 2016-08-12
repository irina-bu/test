import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


/**
 * Created by irina.bushinskaya on 8/11/2016.
 */

public class TestMail extends TestRun {

    @Test(dataProvider = "mydata2", dataProviderClass = TestDataProvider.class)

    public void loginLogout(TestData data) throws Exception {
        driver.get(baseUrl);
        WebElement button_login = driver.findElement(By.xpath(Locators.bEnter1));
        button_login.click();
        WebElement input_login = driver.findElement(By.xpath(Locators.Login));
        WebElement input_password = driver.findElement(By.xpath(Locators.Password));
        TestMethods.fillField(input_login, data.Login1);
        TestMethods.fillField(input_password, data.Passw);
        WebElement button_login2 = driver.findElement(By.xpath(Locators.bEnter2));
        button_login2.click();
        WebElement current_user = driver.findElement(By.xpath(Locators.CurrentUser));
        TestMethods.assertEqualsLocator("John Smith", current_user);
        current_user.click();
        Thread.sleep(3000);
        WebElement open_mail = driver.findElement(By.xpath(Locators.bMail));
        open_mail.click();
        Thread.sleep(15000);

        int count;
        try {
            count = Integer.parseInt(driver.getTitle().split(" ")[0]);
        } catch (Exception ex) {
            count = 0;
        }

        System.out.println("Number of unread messages: " + count);
    }
}


