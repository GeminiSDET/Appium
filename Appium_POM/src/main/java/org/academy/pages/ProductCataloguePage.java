package org.academy.pages;

import java.util.List;

import org.academy.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCataloguePage extends AndroidActions{

	  AndroidDriver driver;
	    
		public ProductCataloguePage(AndroidDriver driver) {
			super(driver);
			this.driver=driver;
			PageFactory.initElements(new AppiumFieldDecorator(driver),this);
		}
		
		@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
		public List<WebElement> addToCart;
		
		@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
		public WebElement cart;
		
		
		public void addItemToCartByIndex(int index) {
			addToCart.get(index).click();
		}
		
		public CartPage goToCartPage() throws InterruptedException {
			cart.click();
			Thread.sleep(5000);
			return new CartPage(driver);
		}		
}
