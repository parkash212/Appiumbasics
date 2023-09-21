package Appiumclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ScrollGesture {
	
	@Test
	public void ScrollingGesture() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();
		// first we need to send device name in which we want to automate
options.setDeviceName("parkash");
options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		
		// where to scroll is known prior
		// here we use androiduiAutomator locator 
		// in google engine there is a class UiScrollable after this we have to call selector class
		// this is a method = scrollIntoView
		// what you want to scroll for this we have to give value of text
		// double coutes in doubls cotes are not allowed for this we have given back slash 
		
driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
Thread.sleep(2000);
	}

}
