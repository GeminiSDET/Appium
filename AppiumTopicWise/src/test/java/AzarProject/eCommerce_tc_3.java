package AzarProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_3 extends BaseTest {

	@Test
	public void FillForm() throws InterruptedException
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Azar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		//scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
// or	driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART'])[1]")).click();
		
		//add to Cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(5000);
		//Explicit Wait
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		
		//Cart Page [Total price of the product]
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count=productPrices.size();
		
		double totalSum=0;
		for(int i=0; i<count; i++) {
			String amountString=productPrices.get(i).getText();
		//removing $ from the price $160.97 b using substring and double is used coz of decimal
			Double price=getFormattedAmount(amountString); 
			totalSum = totalSum + price; // 160.97 + 120.0
		}
		
		String displaySum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Double displayFormattedSum=getFormattedAmount(displaySum);
		Assert.assertEquals(totalSum, displayFormattedSum,0.01);

		//longPress
		WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		longPressAction(ele);
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		

	}
}