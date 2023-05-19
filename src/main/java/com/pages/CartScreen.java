package com.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartScreen {
	
	public CartScreen(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
	public AndroidElement title;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
	public List<AndroidElement> productNameText;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productPrice")
	public AndroidElement productPriceText;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/productAddCart")
	public AndroidElement productAddCartBtn;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public AndroidElement totalAmountLabel;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	public AndroidElement sendEmailCheckbox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnProceed")
	public AndroidElement visitWebsiteBtn;
	
	

}
