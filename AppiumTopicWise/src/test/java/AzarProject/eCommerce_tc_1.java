package AzarProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest {

	@Test
	public void FillForm()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Azar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		//scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));
		
		//add to Cart from List
		int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<productCount;i++) {
			String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(productName.equalsIgnoreCase("Jordan 6 Rings")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		//add to Cart
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		//Explicit Wait
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
		
		//Cart Page
		String lastPageProduct=driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(lastPageProduct,"Jordan 6 Rings");
		
		
		
	}
}