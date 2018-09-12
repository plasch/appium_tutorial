package App_Raaga;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class RaagaCore {

    public static AndroidDriver<AndroidElement> Capabilities() throws MalformedURLException
    {
        // Path to apk file
        File appDir = new File("apks");
        File app = new File(appDir, "com.raaga.android-1.apk");

        DesiredCapabilities Capabilities = new DesiredCapabilities();
        Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus 5");
//        Capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "25");
        Capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), Capabilities);
        return driver;
    }
}
