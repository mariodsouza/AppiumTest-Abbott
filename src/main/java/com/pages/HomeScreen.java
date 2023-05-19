package com.pages;

import org.openqa.selenium.support.PageFactory;

import com.appium.TestBase;
import com.utilities.ReadProperties;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends TestBase{
	
	String country = ReadProperties.getProperty("country");
	String countryUIAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + country + "\"))";
	String id = "";
	
	public HomeScreen(AppiumDriver<MobileElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    public AndroidElement title;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    public AndroidElement countrySelector;
	
//	@AndroidFindBy(uiAutomator = countryUIAutomator)
//    public AndroidElement countryOptions;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public AndroidElement nameInputBox;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    public AndroidElement genderRadioBtnMale;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    public AndroidElement genderRadioBtnFemale;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public AndroidElement letsShopBtn;
	
	
	

}
