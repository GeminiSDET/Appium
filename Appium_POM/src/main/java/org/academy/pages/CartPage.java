package org.academy.pages;
import java.util.List;

import org.academy.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartPage extends AndroidActions{
	
	AndroidDriver driver;
	
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	public List<WebElement> productList;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement totalAmount;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	public WebElement terms;
	
	@AndroidFindBy(id="android:id/button1")
	public WebElement acceptButton;
	
	@AndroidFindBy(className="android.widget.CheckBox")
	public WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	public WebElement proceed;
	
	public List<WebElement> getProductList()
	{
		return productList;
	}
	public double getProductsSum()
	{
		int count=productList.size();
		double totalSum=0;
		for(int i=0; i<count; i++) {
			String amountString=productList.get(i).getText();
			Double price=getFormattedAmount(amountString); 
			totalSum = totalSum + price;
		}
		return totalSum;
	}
	
	public double getTotalAmountDisplayed() {
		return getFormattedAmount(totalAmount.getText());
	}
	
	public void acceptTermsConditions() {
		longPressAction(terms);
		acceptButton.click();
	}
	public double getFormattedAmount(String amount) {
		Double price=Double.parseDouble(amount.substring(1));
		return price;
	}
	
	public void submitOrder() {
		checkBox.click();
		proceed.click();
	}
	
	
	
	
	
	
	
	
}
