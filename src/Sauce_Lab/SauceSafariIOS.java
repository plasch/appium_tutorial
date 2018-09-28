package Sauce_Lab;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SauceSafariIOS {

    public static void main(String[] args) throws MalformedURLException, InterruptedException
    {
        DesiredCapabilities dc = DesiredCapabilities.iphone();
        dc.setCapability("platformName", "iOS");
        dc.setCapability("platformVersion", "7.1");
//        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
//        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1");
        dc.setCapability("appiumVersion", "1.3.4");
        dc.setCapability("deviceName", "iPhone Simulator");
        dc.setCapability("browserName", "safari");
        // http://sauceUsername:sauceAccessKey@ondemand.saucelabs.com:80/wd/hub
        IOSDriver driver = new IOSDriver(new URL("http://rahul1:e950d779-1817-4c3c-b122-06715b814dfd@ondemand.saucelabs.com:80/wd/hub"), dc);

//        driver.get("http://google.com");
//        Thread.sleep(8000L);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Navigating to Udemy");
        driver.get("https://udemy.com");
        System.out.println("Successfully navigated to Udemy");
        driver.findElement(By.xpath(".//*[@id='ios-splash']/a")).click();
        // SYNTAX: tagname[@attribute='value']
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("SoapUI");
        driver.findElement(By.xpath("//button[contains(@class,search-btn)]/i")).click();
        //System.out.println(driver.getTitle());
        //*[@id="courses"]/li[1]/a/span[2]
        System.out.println(driver.findElement(By.xpath(".//*[@id='courses']/li[1]/a/span[2]")).getText());
    }
}
