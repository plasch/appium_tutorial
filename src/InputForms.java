import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class InputForms {

    public static void main(String[] args) throws MalformedURLException
    {
        File appDir = new File("apks");
        File app = new File(appDir, "bookMyShow-ucb.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus 5");
//        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Click on Login button and then Sign Up
        driver.findElementById("com.bt.bms:id/btnLogin").click();
        driver.findElementById("com.bt.bms:id/btnSignUp").click();

        // Get size of elements by className and fill by index
        int size = driver.findElements(By.className("android.widget.EditText")).size();
        System.out.println(size);

        // Create list and fill each field
        List<WebElement> a = driver.findElements(By.className("android.widget.EditText"));
        a.get(0).sendKeys("Appium");
        a.get(1).sendKeys("Mobile");
        a.get(2).sendKeys("appium@training");
        a.get(3).sendKeys("password");

        driver.findElementById("com.bt.bms:id/action_icon").click();
    }
}