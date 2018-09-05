package API_Demos;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Swipe extends BaseCore {

    public static void main(String[] args) throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver = BaseCore.Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
        driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
        driver.findElementByXPath("//*[@content-desc='9']").click();

        // Swipe
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(element(driver.findElementByXPath("//*[@content-desc='15']")))
                .waitAction()
                .moveTo(element(driver.findElementByXPath("//*[@content-desc='45']")))
                .release()
                .perform();
    }
}