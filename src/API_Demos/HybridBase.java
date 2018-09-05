package API_Demos;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class HybridBase {

    // This class for run app on real or emulator device
    public static AndroidDriver<AndroidElement> Capabilities(String device) throws MalformedURLException
    {
        // Path to apk file
        File appDir = new File("apks");
        File app = new File(appDir, "ApiDemos-debug.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        if (device.equals("emulator")) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus 5");
        } else if (device.equals("real")) {
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus 5");
        }
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        return driver;
    }
}