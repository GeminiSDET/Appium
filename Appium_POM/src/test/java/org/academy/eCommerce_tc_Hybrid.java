package org.academy;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.academy.pages.CartPage;
import org.academy.pages.FormPage;
import org.academy.pages.ProductCataloguePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce_tc_Hybrid extends AndroidBaseTest {

	@Test
	public void FillForm() throws InterruptedException
	{
		formPage.setNameField("Azar");
		formPage.setGender("female");
		formPage.setCountrySelection("Argentina");
		ProductCataloguePage productCatalogue=formPage.submitForm();
		
		productCatalogue.addItemToCartByIndex(0);
		productCatalogue.addItemToCartByIndex(0);
		CartPage cartPage=productCatalogue.goToCartPage();
				
		double totalSum=cartPage.getProductsSum();
		double displayFormattedSum=cartPage.getTotalAmountDisplayed();
		
		Assert.assertEquals(totalSum, displayFormattedSum,0.01);

		cartPage.acceptTermsConditions();
		cartPage.submitOrder();
			
	}
}