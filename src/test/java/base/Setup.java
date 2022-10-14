package base;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Setup {
    public AndroidDriver driver;
    @BeforeTest
    public AndroidDriver setUp() throws MalformedURLException {

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "My Device");
        cap.setCapability("platformName", "Android");
//        cap.setCapability("uuid", "");
        cap.setCapability("appPackage", "com.continuum.emi.calculator");
        cap.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");
        cap.setCapability("autoGrantPermissions", true);
        //loopback address and port num
        URL url=new URL("http://127.0.0.1:4723/wd/hub");
        driver=new AndroidDriver(url,cap);
        //after 30s it will show timeout error
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver; // driver is loaded here. for using this in other pages , we should return it


    }
    @AfterTest
    public void closeApp(){
        driver.quit();
    }




}
