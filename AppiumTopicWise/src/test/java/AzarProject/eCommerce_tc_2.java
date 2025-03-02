package AzarProject;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends BaseTest {

	@Test
	public void FillForm()
	{
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Azar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		
		//scroll
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		//toast
		String toastMessage=driver.findElement(By.xpath("(//android.widget.toast)[1]")).getDomAttribute("name");	
		Assert.assertEquals(toastMessage, "Please enter your name");
	}
}