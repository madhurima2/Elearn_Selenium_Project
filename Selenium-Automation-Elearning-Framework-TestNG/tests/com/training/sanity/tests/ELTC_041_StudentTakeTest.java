package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AddUserELearnPOM;
import com.training.pom.ChangePasswordELearnPOM;
import com.training.pom.LoginPOM;
import com.training.pom.StudentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ELTC_041_StudentTakeTest {

	
	private WebDriver driver;
	private String baseUrl;
	//private LoginPOM loginPOM;
	private AddUserELearnPOM addUserTestPOM;
	private StudentPOM studentTestPOM;
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
		addUserTestPOM = new AddUserELearnPOM(driver); 
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
		addUserTestPOM.sendUserName("student2019");
		addUserTestPOM.sendPassword("madhurima123");
		addUserTestPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First Page  On StudentLogin");
		
		
	}
	
	@AfterMethod
	public void AddUserTrainerTest() { 
		studentTestPOM.StudentTakeTest(); 
		screenShot.captureScreenShot("Student taken test");
	}
	
	/*@AfterTest
	public void UserListTest() { 
		addUserTestPOM.UserList(); 
		screenShot.captureScreenShot("User List  Page Opened");
	} */
	
}
