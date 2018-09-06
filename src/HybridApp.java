import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HybridApp {

    public static void main(String[] args) throws MalformedURLException {
        File appDir = new File("apks");
        File app = new File(appDir, "WebView-tester.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus 5");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        System.out.println(driver.getContext());
        driver.findElement(By.id("cz.lsrom.webviewtest:id/url")).sendKeys("google.com");
        driver.findElement(By.id("cz.lsrom.webviewtest:id/ok_btn")).click();

        Set<String> s = driver.getContextHandles(); // 2 views
//        Set set = driver.getContextHandles(); // 2 views
        for (String handle: s)
        {
            System.out.println(handle);
        }

        // To enable WebView debugging, call the static method setWebContentsDebuggingEnabled on the WebView class
        driver.context("WEBVIEW_cz.lsrom.webviewtest");
        driver.findElement(By.name("q")).sendKeys("Handling hybrid app");
        driver.context("NATIVE_APP");
    }
}
