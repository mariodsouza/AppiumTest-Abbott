package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.appium.TestBase;
import com.pages.CartScreen;
import com.pages.HomeScreen;
import com.pages.ProductScreen;
import com.pages.WebsiteScreen;
import com.utilities.ReadProperties;

import io.appium.java_client.MobileBy;

public class SmokeTest extends TestBase {
	
	@Test (description = "Test case to add products to cart and checkout", groups = "Smoke", priority = 1)
	public void Test1() {
		
		SoftAssert sa = new SoftAssert();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		String country = ReadProperties.getProperty("country"); //get the value of country from properties file
		String name = ReadProperties.getProperty("userName"); //get the value of name from properties file
		String productName1 = "PG 3"; //Name of the first product
		String productName2 = "Nike SFB Jungle"; //Name of the second product
		
		HomeScreen homeScreen = new HomeScreen(driver); //create object of HomeScreen
		
		System.out.println("You are on screen: " + homeScreen.title.getText());
		
		homeScreen.countrySelector.click(); //click on country selector
		
		driver.findElement(
				MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))"))
				.click(); //select a country
		
		homeScreen.nameInputBox.sendKeys(name); //enter the name
		
		homeScreen.genderRadioBtnFemale.click(); //select female gender
		
		homeScreen.letsShopBtn.click(); //click on Lets Shop
		
		ProductScreen productScreen = new ProductScreen(driver); //create object of Product screen
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(productScreen.title)));
		System.out.println("You are on screen: " + productScreen.title.getText());
		
		sa.assertTrue(productScreen.title.isDisplayed(), "Product screen is not displayed"); //verify Products screen is displayed
	
		//scroll to the first product
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ productName1 +"\"))"));
		
		//get the price of the first product
		float productName1Price = productPrice(driver.findElement(By.xpath("//*[@text='"+ productName1 + "']/following-sibling::android.widget.LinearLayout/child::android.widget.TextView[starts-with(@text,'$')]")).getText());
		
		//add the first product to cart
		driver.findElement(By.xpath("//*[@text='"+ productName1 + "']/following-sibling::android.widget.LinearLayout/child::android.widget.TextView[@text='ADD TO CART']")).click();
		
		//scroll to the second product
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+ productName2 +"\"))"));
		
		//get the price of the first product
		float productName2Price = productPrice(driver.findElement(By.xpath("//*[@text='"+ productName2 + "']/following-sibling::android.widget.LinearLayout/child::android.widget.TextView[starts-with(@text,'$')]")).getText());
		
		//add the second product to cart
		driver.findElement(By.xpath("//*[@text='"+ productName2 + "']/following-sibling::android.widget.LinearLayout/child::android.widget.TextView[@text='ADD TO CART']")).click();
		
		String cartCounterLabelString = productScreen.cartCounterLabel.getText(); //get number of items in cart
		
		sa.assertEquals(cartCounterLabelString, "2", "Number of items in cart is incorrect");
		
		//click on cart button
		productScreen.cartBtn.click();
		
		CartScreen cartScreen = new CartScreen(driver); //create object of CartScreen
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(cartScreen.title)));
		System.out.println("You are on screen: " + cartScreen.title.getText());
		
		sa.assertEquals(cartScreen.title.getText(), "Cart", "Cart screen is not displayed"); //verify Cart screen is displayed
		
		sa.assertEquals(cartScreen.productNameText.get(0).getText(), productName1, "product1 name doesn't match");//verify Product1 is added in the card
		sa.assertEquals(cartScreen.productNameText.get(1).getText(), productName2, "product2 name doesn't match");//verify Product2 is added in the card
		
		//verify the total price
		float total = productPrice(cartScreen.totalAmountLabel.getText());
		sa.assertEquals(total, productName1Price+productName2Price, "Total price is incorrect");
		
		cartScreen.sendEmailCheckbox.click(); //click on Send email checkbox
		
		cartScreen.visitWebsiteBtn.click(); //click on Visit website button
		
		WebsiteScreen websiteScreen = new WebsiteScreen(driver); //create object of WebsiteScreen
		
		websiteScreen.searchBox.sendKeys("General Store"); //enter text in the search box
		
		driver.navigate().back(); //navigate back to Home page
		
		sa.assertEquals(homeScreen.title.getText(), "General Store", "Home screen is not displayed"); //verify Home screen is displayed
		
		sa.assertAll(); //verify all the assertions
	}
	
	//helper method for getting the product price in float type
	public float productPrice(String price) {
		String noSpaceStr = price.replaceAll("\\s", "");
		float value = Float.parseFloat(noSpaceStr.replace("$", "0"));
		return value;
	}
	
	
}
