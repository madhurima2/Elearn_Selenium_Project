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

public class ELTC_044_StudentDiscussionForum {

	
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
	public void TeacherAddForum() { 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'My courses')]")).click();
		screenShot.captureScreenShot("My course page");
		driver.findElement(By.xpath("//img[@id='toolimage_5751']")).click();
		screenShot.captureScreenShot("Forum categories  page");
		
		//Add forum category
		
		driver.findElement(By.xpath("//input[@id='forumcategory_forum_category_title']")).sendKeys("Forum2");
		driver.findElement(By.xpath("//button[@id='forumcategory_SubmitForumCategory']")).click();
		screenShot.captureScreenShot("Forum category added");
		
		//Add forum 
		driver.findElement(By.xpath("//div[@id='toolbar-forum']//a[1]//img[1]")).click();
		driver.findElement(By.xpath("//input[@id='forumcategory_forum_title']")).sendKeys("ForumName");
		driver.findElement(By.xpath("//button[@id='forumcategory_SubmitForum']")).click();
		screenShot.captureScreenShot("Forum  added");
		
		//Add Group
		driver.findElement(By.xpath("//div[@id='toolbar-groups']//a[1]//img[1]")).click();
		driver.findElement(By.xpath("//input[@id='create_groups_number_of_groups']")).sendKeys("1");
		driver.findElement(By.xpath("//button[@id='create_groups_submit']")).click();
		driver.findElement(By.xpath("//input[@name='group_0_name']")).sendKeys("GroupName");
		driver.findElement(By.xpath("//input[@id='places_0']")).sendKeys("3");
		driver.findElement(By.xpath("//button[@id='create_groups_step2_submit']")).click();
		screenShot.captureScreenShot("Add group");
		
		//Add Thread
		driver.findElement(By.xpath("//a[contains(text(),'Group 0001')]")).click();
	}
	
	@AfterTest
	public void StudentForm() { 
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(text(),'My courses')]")).click();
		screenShot.captureScreenShot("My course page");
		driver.findElement(By.xpath("//img[@id='toolimage_5751']")).click();
		
			
		
		driver.findElement(By.xpath("//button[@id='form_submit']")).click();
		
		studentTestPOM.StudentAssessment(); 
		screenShot.captureScreenShot("");
	} 
	
}
