package ECommerceApp;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


// now to check exactly product name is displaying in cart
public class TestCase003 {
	@Test
	public void ProductPriceCpature() throws MalformedURLException, InterruptedException {
		
	UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("parkash");
	options.setApp("C:\\Users\\iMark Admin\\Desktop\\Code editor\\Appium\\src\\test\\java\\resources\\General-Store.apk");
	AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	driver.findElement(By.id( "android:id/text1")).click();
	driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
	driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rider");
	// now when you enter name ; keyboard section comes, to hide this - we need to use special method 
	driver.hideKeyboard(); // to hide keyboard
	// radio checkbox
	driver.findElement(By.id( "com.androidsample.generalstore:id/radioFemale")).click();
	driver.findElement(By.id( "com.androidsample.generalstore:id/btnLetsShop")).click();
	
	// add to cart
	 // after this you have 2 product but there is a problem i.e add to cart because 2 products ka same ha 
	
	driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click(); // ist point
	driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click(); // 2nd point
// but ye karne par bhi issue ayega kyunki suppose aap ist product par click karte ho - then text chnages to "Added to cart" , 
	 driver.findElement(By.id( "com.androidsample.generalstore:id/appbar_btn_cart")).click(); 
	Thread.sleep(2000);
	 WebDriverWait wait =  new WebDriverWait(driver,Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
	
	// so isliye humko 2nd point me bhi get(o) ayega in place of get(1)
	
	// Cart icon button
	
	 
 // after this our gooal is to check product prices
	 List<WebElement> productprices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
int productCount = 	productprices.size(); 

double sum =0;
for(int i=0;i<productCount;i++) {
	
	String amountString = productprices.get(i).getText() ;
	// now problem is price ke aage dollar ka sign ha usoko remove karna ha 
	Double prices = Double.parseDouble(amountString.substring(1));
	// iska matlab ha ki hume vo string chahiye jo ist se start ho rha ha so automatically dollar sign removes
	sum = sum + prices;
	
	//System.out.println("price of  product" +sum);
	
}
System.out.println("price of  product" +sum);
// total price
String displaysum = driver.findElement(By.id( "com.androidsample.generalstore:id/totalAmountLbl")).getText() ;
Double totalprices = Double.parseDouble(displaysum.substring(1));
System.out.println("total price of product" +totalprices);

// long press on terms and conditions 
WebElement id = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)id).getId()
		,"duration",2000));
// now a popup appears 

driver.findElement(By.id("android:id/button1")).click();

//clicking on checkbox

driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();

//visit to website buton

driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
 

		
		
	}

}
