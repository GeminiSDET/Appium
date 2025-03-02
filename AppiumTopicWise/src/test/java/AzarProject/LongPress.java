package AzarProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;

public class LongPress extends BaseTest{
	
	@Test
	public void LongPressGesture() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
		driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
		
		//LongClick
		WebElement ele=driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
     	longPressAction(ele); //code of long press in BaseTest
	
		String menuText=driver.findElement(By.id("android:id/title")).getText();
		Assert.assertEquals(menuText, "Sample Menu");
		Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
//		System.out.println(driver.getPageSource());
		Thread.sleep(20000);
	}

}
