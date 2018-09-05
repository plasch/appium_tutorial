package API_Demos;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UIAutomatorTest extends BaseCore {

    public static void main(String[] args) throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver = BaseCore.Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // SYNTAX: driver.findElementByAndroidUIAutomator("attribute("value")")
        driver.findElementByAndroidUIAutomator("text(\"Views\")").click();

        //  Validate clickable feature for all options
        //  SYNTAX: driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");
        System.out.println(driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size());
    }
}