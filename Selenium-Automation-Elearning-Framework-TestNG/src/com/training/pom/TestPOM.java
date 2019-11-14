package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestPOM {
	private WebDriver driver; 
	
	public TestPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='form-login_submitAuth']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	private WebElement UserIconDropDown; 
	
	@FindBy(id="logout_button")
	private WebElement logOutBtn; 
	
	@FindBy(xpath="//div[@class='panel panel-default block-admin-users']//a[contains(text(),'User list')]")
	private WebElement UserList;
	
	@FindBy(xpath="//tr[2]//td[11]//a[6]//img[1]")
	private WebElement Edit;
	
	
	
	
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
	
	public void Teacher()
	{
		driver.findElement(By.xpath("//a[contains(text(),'selenium_nov')]")).click();
		driver.findElement(By.xpath("//img[@id='toolimage_5749']")).click();
		driver.findElement(By.xpath("//div[@class='actions']//a[1]//img[1]")).click();
		driver.findElement(By.xpath("//input[@id='exercise_title']")).sendKeys("online quiz");
		driver.findElement(By.id("advanced_params")).click();
		driver.findElement(By.xpath("//input[@id='exerciseType_0']")).click();
		
		WebElement startTime = driver.findElement(By.xpath("//input[@id='qf_f3ade0']"));
		boolean selected = startTime.isSelected();
	    
    
	    
	    if(selected){
	    	System.out.println("Start Time is Enabled");
	    	 
	     }
	     else {
	    	 System.out.println("Start Time is not Enabled");
	    	 startTime.click();
	    	 driver.findElement(By.xpath("//p[@id='start_time_alt_text']")).click();
	     }
		
		driver.findElement(By.xpath("//input[@id='pass_percentage']")).sendKeys("60");
		driver.findElement(By.xpath("//button[@id='exercise_admin_submitExercise']")).click();
		
		//MCQ Questions
		driver.findElement(By.xpath("//section[@id='cm-content']//li[1]//div[1]//a[1]//img[1]")).click();
		driver.findElement(By.xpath("//input[@id='question_admin_form_questionName']")).sendKeys("which course your learning");
		driver.findElement(By.xpath("//input[@id='qf_49824c']")).click();
		WebElement iframeElement = driver.findElement(By.xpath("//tr[1]//td[3]"));

		//now use the switch command
		driver.switchTo().frame(iframeElement);
		iframeElement.sendKeys("selenium");
		driver.switchTo().frame(0);
		
	
		
		WebElement iframeElement2 = driver.findElement(By.xpath("//tr[2]//td[3]"));

		//now use the switch command
		driver.switchTo().frame(iframeElement2);
		iframeElement2.sendKeys("java");
		driver.switchTo().frame(0);
		
		WebElement iframeElement3 = driver.findElement(By.xpath("//tr[3]//td[3]"));

		//now use the switch command
		driver.switchTo().frame(iframeElement3);
		iframeElement3.sendKeys("c");
		driver.switchTo().frame(0);
		
		WebElement iframeElement4 = driver.findElement(By.xpath("//tr[4]//td[3]"));

		//now use the switch command
		driver.switchTo().frame(iframeElement4);
		iframeElement4.sendKeys("c#");
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//button[@id='submit-question']")).click();
		
		//2nd question
		
		driver.findElement(By.xpath("//section[@id='cm-content']//li[1]//div[1]//a[1]//img[1]")).click();
		driver.findElement(By.xpath("//input[@id='question_admin_form_questionName']")).sendKeys("which language are you using in selenium");
		driver.findElement(By.xpath("//input[@id='qf_49824c']")).click();
		WebElement iframeElement5 = driver.findElement(By.xpath("//tr[1]//td[3]"));

		//now use the switch command
		driver.switchTo().frame(iframeElement5);
		iframeElement5.sendKeys("python");
		driver.switchTo().frame(0);
		
	
		
		WebElement iframeElement6 = driver.findElement(By.xpath("//tr[2]//td[3]"));

		//now use the switch command
		driver.switchTo().frame(iframeElement6);
		iframeElement6.sendKeys("java");
		driver.switchTo().frame(0);
		
		WebElement iframeElement7 = driver.findElement(By.xpath("//tr[3]//td[3]"));

		//now use the switch command
		driver.switchTo().frame(iframeElement7);
		iframeElement7.sendKeys("c");
		driver.switchTo().frame(0);
		
		WebElement iframeElement8 = driver.findElement(By.xpath("//tr[4]//td[3]"));

		//now use the switch command
		driver.switchTo().frame(iframeElement8);
		iframeElement8.sendKeys("c#");
		driver.switchTo().frame(0);
		
		driver.findElement(By.xpath("//button[@id='submit-question']")).click();
		
	}
	
	public void student()
	{
		
	}
	public  void clickUserIconDropDown() {
		this.UserIconDropDown.click(); 
	}
	
	public void clickLogOut() {
		this.logOutBtn.click(); 
	}
	public void clickUserList() {
		this.UserList.click(); 
	}
	public void editUser(){
		this.Edit.click();
	}
	
}
