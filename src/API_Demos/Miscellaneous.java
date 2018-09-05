package API_Demos;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Miscellaneous extends BaseCore {

    public static void main(String[] args) throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Get name of current activity
        System.out.println(driver.currentActivity());

        // Get current views: Native, Hybrid or WebView
        System.out.println(driver.getContext());

        // Get current device orientation
        System.out.println(driver.getOrientation());

        // Check whether the device is locked or not
        System.out.println(driver.isDeviceLocked());

        //  driver.hideKeyboard();
        driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();

        // Press a particular key on the device
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        // driver.pressKeyCode(AndroidKeyCode.BACK); - This method is deprecated
    }
}