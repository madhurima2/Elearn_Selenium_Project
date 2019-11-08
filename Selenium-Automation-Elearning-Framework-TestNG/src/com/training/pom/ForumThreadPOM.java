package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForumThreadPOM {
	private WebDriver driver; 
	
	public ForumThreadPOM(WebDriver driver) {
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
	
	public void GroupChat()
	{
		driver.findElement(By.xpath("//img[@id='toolimage_5755']")).click();
		driver.findElement(By.xpath("//div[@class='emoji-wysiwyg-editor']")).sendKeys("TC Elearn 45");
		driver.findElement(By.xpath("//button[@id='chat-send-message']")).click();
		
		
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
