package factoryDevices;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CloudDevice implements  IDevice{


    @Override
    public AppiumDriver create() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "aldojlaos1");
        caps.setCapability("browserstack.key", "xhLzLsqYmBav1NpygDDo");

        // Set URL of the application under test
        caps.setCapability("app", "bs://5c833386723c8434ce78470bbd99b0d3aa7ffba0");

        // Specify device and os_version for testing
        caps.setCapability("device", "Xiaomi Redmi Note 8");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "Taller Final");
        caps.setCapability("build", "V000.1");
        caps.setCapability("name", "my conection to browser stack");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        /* Write your Custom code here */

        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        return driver;
    }
}
