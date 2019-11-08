package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;
import com.training.pom.ELearnPOM;

public class ELTC_019_ViewUserList {

	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private ELearnPOM eLearnPOM;
	
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		eLearnPOM = new ELearnPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterGroups
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test(priority=0)
	public void validLoginTest() {
		eLearnPOM.sendUserName("admin");
		eLearnPOM.sendPassword("admin@123");
		eLearnPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First Page  On Login");
	}
	
	@AfterMethod
	public void clickUserListTest() {
		eLearnPOM.clickUserList(); 
		screenShot.captureScreenShot("User List Displayed");
	}
	@AfterTest
	public void editUserDetail() {	
	eLearnPOM.editUser(); 
		screenShot.captureScreenShot("Edit user information displayed");
	}
	
}
