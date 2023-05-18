package com.appium;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.utilities.ReadProperties;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {

	public static AndroidDriver<MobileElement> driver;
	public static String DeviceName = ReadProperties.getProperty("deviceName");

	@SuppressWarnings("unchecked")
	@BeforeSuite
	public void Setup() throws IOException, InterruptedException {

		SetDrivers set = new SetDrivers();

		driver = (AndroidDriver<MobileElement>) set.setAndroidDriver(DeviceName);

	}

	@AfterSuite
	public void tearDown() throws IOException {
		driver.closeApp();
		driver.quit();
	}
}