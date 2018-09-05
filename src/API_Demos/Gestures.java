package API_Demos;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class Gestures extends BaseCore {

    public static void main(String[] args) throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Tap
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(element(driver.findElementByXPath("//android.widget.TextView[@text='Expandable Lists']")))
                .perform();

        driver.findElementByXPath("//android.widget.TextView[@text='1. Custom Adapter']").click();

        // Long press
        touchAction.longPress(element(driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"))))
                .waitAction()
                .release()
                .perform();

        System.out.println(driver.findElementById("android:id/alertTitle").getText());
    }
}