package Appiumclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	@BeforeClass()
	public void ConfigureAppium() throws MalformedURLException {
		
		 service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\iMark Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
					service.start();
						
				UiAutomator2Options options = new UiAutomator2Options();
						// first we need to send device name in which we want to automate
				options.setDeviceName("parkash");
				options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");
					
					//DesiredCapabilities capabilities = new DesiredCapabilities();
				 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	
	}
	public void tearDown()
	{
		driver.quit();
		service.stop();
		
	}
}
