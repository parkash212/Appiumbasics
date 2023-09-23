package Appiumclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SwippingDemo {
	@Test
	public void swippingDemos() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();
		// first we need to send device name in which we want to automate
options.setDeviceName("parkash");
options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.findElement(AppiumBy.accessibilityId("Views")).click();
driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click(); //ImageView[1]"))
//driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();

//befoer swipping your focus should be on the first image and after one left swipe , the focus will be going to the 2nd image

//so with the help of appium write a code that ist image focus should be true  and then apply swipe and then check it turning to
//false 

// ist image
WebElement firstimage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),"true");

((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",((RemoteWebElement)firstimage)
		.getId(),"direction","left", 
		"percent",0.75));
//direction and percentage is mandatory
// here percentage is how much thumb size you have to give

// apply swipe code
// now focus is on 2nd image - go to emulator and swipe to 2nd image


//2nd image
Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"),"false");




	}

}
