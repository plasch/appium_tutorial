package Mobile_Browser;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class BrowserTest extends ChromeBase {

    public static void main(String[] args) throws MalformedURLException
    {
        AndroidDriver<AndroidElement> driver = Capabilities();
        // Facebook
//        driver.get("http://facebook.com");
//        driver.findElementByName("email").sendKeys("qwerty");
//        driver.findElementByName("pass").sendKeys("12345");
//        driver.findElementByXPath("//button[@value='Log In']").click();

        // Cricbuzz
        driver.get("http://cricbuzz.com");
        driver.findElementByXPath("//a[@href='#menu']").click();
        driver.findElementByCssSelector("a[title='Cricbuzz Home']").click();
        System.out.println(driver.getCurrentUrl());

        // Scroll down
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,480)", "");
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,480)", "");

        Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='Top Stories']")).getAttribute("class").contains("header"));
    }
}
