package org.academy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;

public class eCommerce_tc_2 extends AndroidBaseTest {

	//Directly jump to page
	@BeforeMethod
	public void preSetUp() {
		Activity activity=new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		((JavascriptExecutor)driver).executeScript("mobile: startActivity",ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	}
	@Test
	public void FillForm_ErrorValidation()
	{
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		String toastMessage=driver.findElement(By.xpath("(//android.widget.toast)[1]")).getDomAttribute("name");	
		Assert.assertEquals(toastMessage, "Please enter your name");
		
	}
	
	@Test
	public void FillForm_PositiveFlow()
	{
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Azar");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();

		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		Assert.assertTrue(driver.findElements(By.xpath("(//android.widget.toast)[1]")).size()<1);
	}
}