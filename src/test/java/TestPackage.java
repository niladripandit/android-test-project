
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.File;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Dimension;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class TestPackage {

    public static AndroidDriver driver;

    public static void main(String[] args){


        File app = new File("/Users/niladrisekharpandit/Downloads/XXXXXX.apk");   // Blibli-661.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "5200a539fe306421");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.10.1");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Espresso");
        capabilities.setCapability("appPackage","XXXXXX");
        capabilities.setCapability("appActivity","XXXXXX");


        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Dimension dimensions = driver.manage().window().getSize();

        for(int i=1; i>3; i++)
        {
            Double screenHeightStart = dimensions.getHeight() * 0.5;

            /* int scrollStart = screenHeightStart.intValue(); */

            Double screenHeightEnd = dimensions.getHeight() * 0.2;

            int scrollEnd = screenHeightEnd.intValue();

            int startPoint=(int)(dimensions.getHeight() * 0.70);
            int endPoint=(int)(dimensions.getHeight() * 0.20);
            int duration=2000;

            TouchAction action = new TouchAction(driver);
            action.longPress(PointOption.point(0, startPoint)).moveTo(PointOption.point(0, endPoint)).release().perform();


        }

        //driver.quit();

    }


}
