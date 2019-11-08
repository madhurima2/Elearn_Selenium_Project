package com.training.pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentPOM {
	
	private WebDriver driver; 
	
	public StudentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//a[contains(text(),'Homepage')]")
	private WebElement HomePage; 
	
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement courseCatalog;
	

	
	@FindBy(xpath="//div[@class='input-group']//button[1]")
	private WebElement searchButton;
	
	
	
	
	@FindBy(xpath="//section[@id='cm-content']//div[@class='container']//div[1]//div[1]//div[1]//a[1]//img[1]")
	private WebElement clickCourse;
	
	//You have been registered to course: selenium message should get displayed
	@FindBy(xpath="//a[contains(text(),'cour022')]")
	private WebElement courseIcon;
	
		
	
	@FindBy(xpath="//img[@id='toolimage_1749']")
	private WebElement forumsIcon;
	
	@FindBy(xpath="//img[@id='toolimage_1752']")
	private WebElement groupIcon;
	
	@FindBy(xpath="//a[contains(text(),'Group 0001')]")
	private WebElement groupLink;
	
	@FindBy(xpath="//div[text()='(none)']")
	private WebElement ChatIcon;
	
	@FindBy(xpath="//i[@class='fa fa-comments text-muted']")
	private WebElement LeaveMessageIcon;
	
	@FindBy(xpath="//div[@class='emoji-wysiwyg-editor']")
	private WebElement Write;
	
	@FindBy(xpath="//button[@id='chat-send-message']")
	private WebElement sendMessage;
	
	//TC 41 ---Student login locators *******************************************
	@FindBy(xpath="//a[contains(text(),'Course catalog')]")
	private WebElement CourseCatalog;
	
	@FindBy(xpath="//a[@class='btn btn-primary btn-large']")
	private WebElement ScourseCatalog;
	
	@FindBy(xpath="//input[@name='search_term']")
	private WebElement ScourseSearchBox;

	@FindBy(xpath="//a[@class='btn btn-success btn-sm']")
	private WebElement SsubscribeButton;
	
	@FindBy(xpath="//a[@class='btn btn-lg btn-success btn-block']")
	private WebElement ScourseHome;
	
	@FindBy(xpath="//img[@id='toolimage_5749']")
	private WebElement STests;
	
	@FindBy(xpath="//a[contains(text(),'selenium_test1')]")
	private WebElement STestName;
	
	@FindBy(xpath="//a[@class='btn btn-success btn-large']")
	private WebElement SStartTest;
	
	@FindBy(xpath="//html")
	private WebElement SQuestion1;
	
	@FindBy(xpath="//button[@name='save_now']")
	private WebElement SnextQuestion;
	
	@FindBy(xpath="//img[@id='toolimage_2261']")
	private WebElement Assesment;
	
	@FindBy(xpath="//tr[2]//td[2]//a[1]")
	private WebElement TestName2;
	
	@FindBy(xpath="//input[@id='choice-29-1']")
	private WebElement Radio;
	
	
	@FindBy(xpath="//button[@name='validate_all']")
	private WebElement EndTest;
	
	
	
	public  void StudentTakeTest() {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		CourseCatalog.click();
		ScourseSearchBox.sendKeys("selenium_nov");
		SsubscribeButton.click();
		ScourseHome.click();
		STests.click();
		STestName.click();
		SStartTest.click();	
		SQuestion1.sendKeys("answer");
		SnextQuestion.click();
		
	}
		public  void StudentAssessment() {
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		CourseCatalog.click();
		ScourseSearchBox.sendKeys("coursee");
		SsubscribeButton.click();
		ScourseHome.click();
		Assesment.click();
		TestName2.click();
		SStartTest.click();	
		Radio.click();
		SnextQuestion.click();
		EndTest.click();
		
	}
	
		public  void GroupChat() {
			
		HomePage.click();
		courseCatalog.click();
		ScourseSearchBox.sendKeys("123");
		searchButton.click();
		clickCourse.click();
		ScourseHome.click();
		groupIcon.click();
		ChatIcon.click();
		
		
		WebDriverWait ewait=new WebDriverWait(driver,20);
		WebElement button=ewait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[10]//div[1]//div[1]//button[1]//span[1]//span[1]")));
		//this.profile.click();
		
	}
		public  void UserList() {
			
		}
		
}
