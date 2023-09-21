package Appiumclass;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MisclaneousItems {
	
	@Test
	
	public void MisclanousItems() throws MalformedURLException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		// first we need to send device name in which we want to automate
options.setDeviceName("parkash");
options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\ApiDemos-debug.apk");

AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//xpath, id, accesibilityId, classname, androidUIAutomator2

// Apppackage and App activity 
// in this we learn - suppose you want to directly jump to a page to testing without going step by step that is also possible in appium

// ist go to emulator and open desird page which you want to test and then go to Command prompt and give a command 
// adb shell dumpsys window | find "mCurrentFocus" -Windows
Activity activity = new Activity(null, null);




driver.findElement(AppiumBy.accessibilityId("Preference")).click();
driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]")).click();
driver.findElement(By.id("android:id/checkbox")).click();

//now you have to test same thing in landsacpe mode
DeviceRotation landscape = new DeviceRotation(0, 0 , 90);
driver.rotate(landscape);
driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

//copy to clipboard in android - paste it to clipboard
driver.setClipboardText("parkashWiFi");
driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());

// a
driver.pressKey(new KeyEvent(AndroidKey.ENTER));

driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
driver.pressKey(new KeyEvent(AndroidKey.BACK));
driver.pressKey(new KeyEvent(AndroidKey.HOME));


		
	}

}
