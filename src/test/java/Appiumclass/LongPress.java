package Appiumclass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class LongPress {
	@Test
	public void LongPressGesture () throws MalformedURLException {
		//AppiumDriverLocalService service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\iMark Admin\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
//.withIPAddress("127.0.0.1").usingPort(4723).build();
//	service.start();
		
UiAutomator2Options options = new UiAutomator2Options();
		// first we need to send device name in which we want to automate
options.setDeviceName("parkash");
options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

driver.findElement(AppiumBy.accessibilityId("Views")).click();
driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']")); // custom xpath 
// now to perform long press -- for this we have to inject javascript
// appium provide documentation READ IT FROM GOOGLE

((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),"duration",2000));

String  ele2 = driver.findElement(By.id("android:id/title")).getText();
Assert.assertEquals( ele2, "Sample menu");

// here it will take 2 arguments , ist is the script event which you need to pass which is
// "mobile: longClickGesture" and next is option that means MAP you have to provide key value pairs that tell us in which element
//, how much duration i.e ImmutableMap.of() , first argument in this is "elementId" which is key and value of key is ( jo humne custom xpath nikala ha )
// now we have to pass "ele" in value of key and cast it with RemoteRemoteWebElement
// we also need to add a duration


		
	}

}
