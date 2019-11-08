package com.training.sanity.tests;
import java.io.FileReader;
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

public class ELTC_043_Assignment {

	
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
	public void StudentAssignmentTest() throws IOException { 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'Course catalog')]")).click();
		driver.findElement(By.xpath("//input[@name='search_term']")).sendKeys("selenium_nov");
		driver.findElement(By.xpath("//div[@class='input-group']//button[1]")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-lg btn-success btn-block']")).click();
		driver.findElement(By.xpath("//div[@class='image']//img[@class='img-responsive']")).click();;
		driver.findElement(By.id("toolimage_5756")).click();
		screenShot.captureScreenShot("Assignment page");
		driver.findElement(By.xpath("//tr[@id='77']//a[2]//img[1]")).click();
		driver.findElement(By.xpath("//input[@id='form_file']")).click();
		
		//uploading file
		Runtime.getRuntime().exec("C:\\Users\\MadhurimaMandal\\Desktop\\venue.txt");
		
		driver.findElement(By.xpath("//button[@id='form_submit']")).click();
		
		studentTestPOM.StudentAssessment(); 
		screenShot.captureScreenShot("Student taken assessment");
	}
	
	/*@AfterTest
	public void UserListTest() { 
		//CSVReader reader=new CSVReader(new FileReader("c:\\selenium\\demo.csv"));
		addUserTestPOM.UserList(); 
		screenShot.captureScreenShot("User List  Page Opened");
	} */
	
}
