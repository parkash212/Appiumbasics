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
	
	import io.appium.java_client.AppiumBy;
	import io.appium.java_client.android.AndroidDriver;
	import io.appium.java_client.android.options.UiAutomator2Options;
	
	public class NewEcommerceApp {
		@Test
		public void EcommerceApp() throws MalformedURLException{
			
		
	 UiAutomator2Options options = new UiAutomator2Options();
			// first we need to send device name in which we want to automate
	options.setDeviceName("parkash");
	options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\General-Store.apk");
	
	AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.id( "android:id/text1")).click();
	
	//WebElement ele = driver.findElement(By.xpath("//android.widget.TextView[@text='India']"));
	
	// driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	//((JavascriptExecutor)driver).executeScript("mobile: scrollGesture","elementId", (RemoteWebElement)ele.getId)
	
	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	
	//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rider");
	// now when you enter name ; keyboard section comes, to hide this - we need to use special method 
	//driver.hideKeyboard(); // to hide keyboard
	// radio checkbox
	driver.findElement(By.id( "com.androidsample.generalstore:id/radioFemale")).click();
	
	driver.findElement(By.id( "com.androidsample.generalstore:id/btnLetsShop")).click();
	
	// code to validate toast message - it comes when you click on lets shop button without providing any data in name field
	// but there is a glitch here i.e appium can not inspect toast same , so there is a trick 
	// who ever created the toast message that toast message have this Tag Name  -- android.widget.Toast
	String so = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
	Assert.assertEquals(so, "Please enter your name" );
	
	
			
		}
	
	}
