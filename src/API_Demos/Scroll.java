package API_Demos;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class Scroll extends BaseCore {

    public static void main(String[] args) throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Dimension size = driver.manage().window().getSize();
        int x = size.getWidth() / 2;
        int start = (int) (size.getHeight() * 0.60);
        int end = (int) (size.getHeight() * 0.10);
        // driver.swipe(x, start, x, end, 2000); - is deprecated

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(x, start))
                .waitAction()
                .moveTo(PointOption.point(x, end))
                .release().perform();

        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        // Scroll down until don't reach text "WebView"
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
    }
}