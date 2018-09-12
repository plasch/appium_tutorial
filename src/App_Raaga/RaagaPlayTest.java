package App_Raaga;

import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;


public class RaagaPlayTest extends RaagaCore {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        AndroidDriver<AndroidElement> driver = Capabilities();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Step 1: Open Raaga app

        // Step 2: Scroll down and select Trending now option in Menu
//        driver.scrollTo("Trending Now");
        TouchAction touchAction = new TouchAction(driver);
        WebElement abc=driver.findElementById("com.raaga.android:id/xrellay_TrendingNow");
        touchAction.tap(element(abc)).perform();

        //Step 3: Select a song called "Tum"
        List<AndroidElement> xyz = driver.findElementsByClassName("android.widget.TextView");
        for (int i = 0; i < xyz.size(); i++)
        {
            if(xyz.get(i).getText().contains("Tum"))
            {
                //Step 4: Long click on selected Song
                touchAction.longPress(element(xyz.get(i))).perform();
                Thread.sleep(5000L);
                driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Play All\")").click();
                System.out.println("Song succesfull played");
            }
        }
    }
 }