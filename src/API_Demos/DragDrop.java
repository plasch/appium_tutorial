package API_Demos;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.offset.ElementOption.element;

public class DragDrop extends BaseCore {

    public static void main(String[] args) throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();

        // Drag and drop
        TouchAction touchAction = new TouchAction(driver);
        touchAction.longPress(element(driver.findElementsByClassName("android.view.View").get(0)))
                .moveTo(element(driver.findElementsByClassName("android.view.View").get(1)))
                .release()
                .perform();
    }
}