package com.appium;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SetDrivers extends TestBase{

		public AppiumDriver<MobileElement> setAndroidDriver(String DeviceName) throws InterruptedException, IOException {
	        {

	            DesiredCapabilities capabilities = new DesiredCapabilities();
	            
	            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
	            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
	            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
	            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
	            capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir") + "/src/test/resources/General-Store.apk");
	            
	            URL url = new URL("http://0.0.0.0:4723/wd/hub/");

	            driver = new AndroidDriver<MobileElement>(url, capabilities);
	            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	            
	            return driver;
	        }
	    }
		
		
		//method for setting iOSDriver, etc
		public AppiumDriver<MobileElement> setiOSDriver(String DeviceName) throws InterruptedException, IOException {
			return null;
			
		}



}
