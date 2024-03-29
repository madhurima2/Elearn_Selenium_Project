package com.training.pom;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.training.generics.ScreenShot;

public class AddUserELearnPOM {
	
	private WebDriver driver; 
	private ScreenShot screenShotTest;
	public AddUserELearnPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='form-login_submitAuth']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Administration')]")
	private WebElement Admin; 
	
	@FindBy(xpath="//a[contains(text(),'Add a user')]")
	private WebElement AddUser; 
	
	@FindBy(xpath=".//*[@name='firstname']")
	private WebElement fname;
	
	@FindBy(xpath="//input[@id='lastname']")
	private WebElement lname;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement Email; 
	
	@FindBy(xpath="//input[@id='phone']")
	private WebElement Phone; 
	
	@FindBy(name="username")
	private WebElement user; 
	
	@FindBy(name="password[password_auto]")
	private WebElement password_button; 
	
	@FindBy(xpath=".//*[@name='password[password]']")
	private WebElement pswd; 
	
	@FindBy(name="filter-option-inner")
	private WebElement DropDown;
	//div[contains(text(),'Trainer')]
	@FindBy(xpath="//div[10]//div[1]//div[1]//button[1]//span[1]//span[1]")
	private WebElement profile; 
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement clickAdd;
	
	
	@FindBy(name="submit_plus")
	private WebElement ClickAddPlus;
	
	@FindBy(xpath="//div[@class='panel panel-default block-admin-users']//a[contains(text(),'User list')]")
	private WebElement UserList;
	
		
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
		public  void AddUser() {
		this.Admin.click(); this.AddUser.click(); this.fname.clear(); this.fname.sendKeys("reva");
		this.lname.clear();	this.lname.sendKeys("sharma"); this.Email.clear();	this.Email.sendKeys("revasarma@gmail.com");
		this.Phone.clear();	this.Phone.sendKeys("9876543210"); this.user.clear();	this.user.sendKeys("reva30");
		password_button.click();
		pswd.clear(); pswd.sendKeys("reva321"); profile.clear(); pswd.sendKeys("reva321"); DropDown.click();
		WebDriverWait ewait=new WebDriverWait(driver,20);
		WebElement button=ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[10]//div[1]//div[1]//button[1]//span[1]//span[1]")));
		//this.profile.click();
		clickAdd.click();
	}
		
		public void createCategoryCourse()
		{
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Courses categories')]")).click();
			driver.findElement(By.xpath("//div[@class='actions']//a//img")).click();
			
			//Courses categories page
			driver.findElement(By.xpath("//input[@id='course_category_code']")).sendKeys("BL");
			driver.findElement(By.xpath("//input[@id='course_category_name']")).sendKeys("Blended Learning");
			driver.findElement(By.xpath("//input[@id='qf_804699']")).click();
			driver.findElement(By.xpath("//button[@id='course_category_submit']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Admin >create Course
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Create a course')]")).click();
			driver.findElement(By.xpath("//input[@id='update_course_title']")).sendKeys("testing");
			driver.findElement(By.xpath("//input[@id='visual_code']")).sendKeys("tes");
			driver.findElement(By.xpath("//div[17]//label[1]")).click();
			
			//retrieve value from Database
			
		}
		public void createMultipleCategoryCourse()
		{
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Courses categories')]")).click();
			driver.findElement(By.xpath("//div[@class='actions']//a//img")).click();
			
			//Courses categories page
			driver.findElement(By.xpath("//input[@id='course_category_code']")).sendKeys("BL");
			driver.findElement(By.xpath("//input[@id='course_category_name']")).sendKeys("Blended Learning");
			driver.findElement(By.xpath("//input[@id='qf_804699']")).click();
			driver.findElement(By.xpath("//button[@id='course_category_submit']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Admin >create Course
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Create a course')]")).click();
			driver.findElement(By.xpath("//input[@id='update_course_title']")).sendKeys("Selenium");
			driver.findElement(By.xpath("//input[@id='visual_code']")).sendKeys("BL");
			
			driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//ul[@class='select2-selection__rendered']")).sendKeys("Manzoor");
			
			WebElement sub1=driver.findElement(By.xpath("//button[@id='course_category_submit']"));
			sub1.click();
			System.out.println("1st category and course added");
			driver.findElement(By.xpath("//div[17]//label[1]")).click();
			screenShotTest.captureScreenShot("Course Category 1 added");
			
			//2nd category
			
			
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Courses categories')]")).click();
			driver.findElement(By.xpath("//div[@class='actions']//a//img")).click();
			
			//Courses categories page
			driver.findElement(By.xpath("//input[@id='course_category_code']")).sendKeys("WL");
			driver.findElement(By.xpath("//input[@id='course_category_name']")).sendKeys("WebILT");
			driver.findElement(By.xpath("//input[@id='qf_804699']")).click();
			driver.findElement(By.xpath("//button[@id='course_category_submit']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Admin >create Course
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Create a course')]")).click();
			driver.findElement(By.xpath("//input[@id='update_course_title']")).sendKeys("Selenium Course");
			driver.findElement(By.xpath("//input[@id='visual_code']")).sendKeys("WL");
			
			driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//ul[@class='select2-selection__rendered']")).sendKeys("Manzoor");
			
			WebElement sub2=driver.findElement(By.xpath("//button[@id='course_category_submit']"));
			sub2.click();
			System.out.println("2nd category and course added");
			driver.findElement(By.xpath("//div[17]//label[1]")).click();
			screenShotTest.captureScreenShot("Course Category 2 added");
			
			
			
			//3rd category
			
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Courses categories')]")).click();
			driver.findElement(By.xpath("//div[@class='actions']//a//img")).click();
			
			//Courses categories page
			driver.findElement(By.xpath("//input[@id='course_category_code']")).sendKeys("CL");
			driver.findElement(By.xpath("//input[@id='course_category_name']")).sendKeys("ClassRoom");
			driver.findElement(By.xpath("//input[@id='qf_804699']")).click();
			driver.findElement(By.xpath("//button[@id='course_category_submit']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Admin >create Course
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Create a course')]")).click();
			driver.findElement(By.xpath("//input[@id='update_course_title']")).sendKeys("Testing");
			driver.findElement(By.xpath("//input[@id='visual_code']")).sendKeys("TL");
			
			driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//ul[@class='select2-selection__rendered']")).sendKeys("Manzoor");
			
			WebElement sub3=driver.findElement(By.xpath("//button[@id='course_category_submit']"));
			sub3.click();
			System.out.println("3rd category and course added");
			driver.findElement(By.xpath("//div[17]//label[1]")).click();
			screenShotTest.captureScreenShot("Course Category 3 added");
			
			//4th category
			
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Courses categories')]")).click();
			driver.findElement(By.xpath("//div[@class='actions']//a//img")).click();
			
			//Courses categories page
			driver.findElement(By.xpath("//input[@id='course_category_code']")).sendKeys("PJP");
			driver.findElement(By.xpath("//input[@id='course_category_name']")).sendKeys("Pre Joining");
			driver.findElement(By.xpath("//input[@id='qf_804699']")).click();
			driver.findElement(By.xpath("//button[@id='course_category_submit']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Admin >create Course
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Create a course')]")).click();
			driver.findElement(By.xpath("//input[@id='update_course_title']")).sendKeys("JAVA");
			driver.findElement(By.xpath("//input[@id='visual_code']")).sendKeys("JV");
			
			driver.findElement(By.xpath("//span[@class='select2 select2-container select2-container--default select2-container--below select2-container--focus']//ul[@class='select2-selection__rendered']")).sendKeys("Manzoor");
			
			WebElement sub4=driver.findElement(By.xpath("//button[@id='course_category_submit']"));
			sub4.click();
			System.out.println("4th category and course added");
			driver.findElement(By.xpath("//div[17]//label[1]")).click();
			screenShotTest.captureScreenShot("Course Category 4 added");
			
		}
		
		public void invalidCreateCategoryCourse()
		{
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			
			driver.findElement(By.xpath("//a[contains(text(),'Courses categories')]")).click();
			driver.findElement(By.xpath("//div[@class='actions']//a//img")).click();
			
			//Courses categories page
			driver.findElement(By.xpath("//input[@id='course_category_code']")).sendKeys("asd#@!#");
			driver.findElement(By.xpath("//input[@id='course_category_name']")).sendKeys("'!@##!@");
			
			
			
			
			// Either
			WebElement element = driver.findElement(By.name("userName"));
			element.sendKeys("tutorial");
			
			String text = element.getAttribute("value");

			System.out.println(element.getAttribute("type"));
			System.out.println(element.getAttribute("size"));
			
			assertEquals(text, "tutorial");
				
			
			
			//Verification 
			
			try {
				String expectedTitle = null;
				assertEquals(driver.getTitle(), expectedTitle);
			} catch (Exception e) {
				e.printStackTrace(); 
			}
			driver.findElement(By.xpath("//input[@id='qf_804699']")).click();
			driver.findElement(By.xpath("//button[@id='course_category_submit']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Admin >create Course
			driver.findElement(By.xpath("//a[contains(text(),'Administration')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Create a course')]")).click();
			driver.findElement(By.xpath("//input[@id='update_course_title']")).sendKeys("testing");
			driver.findElement(By.xpath("//input[@id='visual_code']")).sendKeys("tes");
			driver.findElement(By.xpath("//div[17]//label[1]")).click();
			
			//retrieve value from Database
			
		}
		public  void UserList() {
			this.Admin.click();
			UserList.click();
		}
		
}
