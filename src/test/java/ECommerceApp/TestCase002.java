package ECommerceApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
public class TestCase002 {
	
	@Test
	
	public void TestCase2() throws MalformedURLException, InterruptedException {
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("parkash");
	options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\General-Store.apk");
	
	AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	// test case is to scroll until you find product - "jordan6 ring"
	
	driver.findElement(By.id( "android:id/text1")).click();

	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));

	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rider");
	// now when you enter name ; keyboard section comes, to hide this - we need to use special method 
	driver.hideKeyboard(); // to hide keyboard
	// radio checkbox
	driver.findElement(By.id( "com.androidsample.generalstore:id/radioFemale")).click();
	
	driver.findElement(By.id( "com.androidsample.generalstore:id/btnLetsShop")).click();
	
	// scrolling to jordan6 ring
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
	// now click add to cart
	// we can not use index no because there are lot of products
	// so we will iterate through each product
	int size = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	for(int i=0;i<size;i++) {
				
  String productname = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
  if(productname.equals("Jordan 6 Rings"))  {
	  driver.findElements(By.id( "com.androidsample.generalstore:id/productAddCart")).get(i).click(); 
  }
	}
	 driver.findElement(By.id( "com.androidsample.generalstore:id/appbar_btn_cart")).click(); 	
	 //Thread.sleep(3000);
			  
		// now to check exactly product name is displaying in cart
	 
	 WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(5));
 wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
 String text = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText(); 	
	 
	 Assert.assertEquals(text, "Jordan 6 Rings");
	 // but when we run - it there is some issue because id xpath is present in cart also in product catalouge , so to reslove this
	 // we can provide wait to determine is se jo pichla vala page tho vo fully load ho gya ha and also you can check Title 
	 // of the page is d different for cart and product

			  
			  
			  
			  
			  
			  
			  
			  
			  
			  
	}

}
