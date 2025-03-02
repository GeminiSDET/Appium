package AzarProject;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class Rotate_CopyPaste_KeyBoard_Activity extends BaseTest {

	@Test
	public void WifiSettingsName() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		//App Package & App Activity -Used to directly jump to specific page
		//Open terminal
		//adb devices
		//adb shell dumpsys window | find "mCurrentFocus"
		Activity activity= new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
		((JavascriptExecutor)driver).executeScript("mobile: startActivity",ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//Rotate
		DeviceRotation landscape=new DeviceRotation(0,0,90);
		driver.rotate(landscape);
			
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle=driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		
		
		//CopyContent
		driver.setClipboardText("AzarWifi");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());	
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		
		//Device Button 
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		
		
		
		
	}
}
