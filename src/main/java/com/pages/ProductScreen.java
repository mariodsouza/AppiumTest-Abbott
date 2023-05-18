package com.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductScreen {
	
	public ProductScreen(AndroidDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	String productName1 = "";
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	public AndroidElement title;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public AndroidElement cartBtn;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/counterText")
	public AndroidElement cartCounterLabel;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	public AndroidElement productNameText;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public AndroidElement productPriceText;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	public AndroidElement productAddCartBtn;
	
	
//	@AndroidFindBy(xpath = "//*[@text='"+ productName1 + "']/following-sibling::android.widget.LinearLayout/child::android.widget.TextView[@text='ADD TO CART']")
//	public AndroidElement product;
	

}
