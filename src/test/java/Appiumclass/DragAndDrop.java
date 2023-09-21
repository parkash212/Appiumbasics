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

public class DragAndDrop {
	@Test
	public void DragandDrops() throws MalformedURLException, InterruptedException {
		UiAutomator2Options options = new UiAutomator2Options();
		// first we need to send device name in which we want to automate
options.setDeviceName("parkash");
options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.findElement(AppiumBy.accessibilityId("Views")).click();
driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

WebElement source = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));

((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of("elementId",((RemoteWebElement)source)
		.getId(),"direction","left", 
		"endX", 827,
		"endY", 729));
Thread.sleep(2000);

WebElement ele = driver.findElement(By.id( "io.appium.android.apis:id/drag_result_text"));
Assert.assertEquals(ele,"Dropped!" );


	}

}
