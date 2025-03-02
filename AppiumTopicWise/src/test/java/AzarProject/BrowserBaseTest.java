package AzarProject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BrowserBaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	@BeforeClass
	public void ConfigureAppium() throws MalformedURLException, URISyntaxException {
		
		service=new AppiumServiceBuilder().withAppiumJS(new File("C://Users//Azar//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("GeminiPixel3a");
		
		//Use [appium --allow-insecure chromedriver_autodownload] at the launch to get chromedriver of any version
		//options.setChromedriverExecutable("D://MobileAutomation//chromedriver-win32//chromedriver-win32//chromedriver.exe");
		
		options.setCapability("browserName","Chrome");
		
		driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
	}
	
	public Double getFormattedAmount(String amount) {
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
		service.stop();
	}
}
