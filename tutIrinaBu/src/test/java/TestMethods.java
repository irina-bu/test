import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;


/**
 * Created by irina.bushinskaya on 8/11/2016.
 */

public class TestMethods extends TestRun {

    public static void fillField(WebElement el, String S1) {
        el.clear();
        el.sendKeys(S1);
    }


    public static void assertEqualsLocator(String S2, WebElement el){
        try {

            assertEquals(S2, el.getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}
