package App_Raaga;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Point;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class RaagaToggleTest extends RaagaCore {

    public static void main(String[] args) throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElementByXPath("com.google.android.gms:id/add_account_chip_title").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Done']").click();
        driver.findElementById("com.raaga.android:id/landing_skip_to_raaga").click();
        driver.findElementByXPath("//android.widget.TextView[@text='World Music']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(resourceId(\"com.raaga.android:id/music_home_raaga_live\"));");
        driver.findElementById("com.raaga.android:id/music_home_raaga_live").click();
        driver.findElementById("com.raaga.android:id/toolbar_logo").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Settings']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Push Notification']").click();

        // Toggle ON
        TouchAction touchAction = new TouchAction(driver);
        Point point = driver.findElementById("com.raaga.android:id/toggle_notifyrecommend").getLocation();
        // touchAction.tap(point.x+20, point.y+30).perform(); - is deprecated
        touchAction.tap(PointOption.point(point.x + 20, point.y + 30)).perform();

        // Toggle OFF
        touchAction.tap(PointOption.point(point.x + 100, point.y + 30)).perform();
    }
}
