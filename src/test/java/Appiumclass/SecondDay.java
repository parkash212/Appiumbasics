package Appiumclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class SecondDay {
	@Test
	public void getuser() throws MalformedURLException {//throws MalformedURLException {
	// appium code need to send to appium server -- mobile
	// so we need to send server detail in ist argument of script belowappiuma
	//AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.0.1:4723"), null);
	
	// to start server programitically
		                                                                      //     C:\Users\iMark Admin\AppData\Roaming\npm\node_modules\appium\build\lib
AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\iMark Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
.withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(300)).build();
	service.start();
		
UiAutomator2Options options = new UiAutomator2Options();
		// first we need to send device name in which we want to automate
options.setDeviceName("parkash");
options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
	
	//DesiredCapabilities capabilities = new DesiredCapabilities();
AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
driver.quit();
service.stop();	

}
}