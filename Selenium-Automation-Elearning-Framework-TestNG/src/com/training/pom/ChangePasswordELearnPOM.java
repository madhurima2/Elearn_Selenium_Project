package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordELearnPOM {
	private WebDriver driver; 
	
	public ChangePasswordELearnPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login")
	private WebElement userName; 
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//button[@id='form-login_submitAuth']")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//a[contains(text(),'Edit profile')]")
	private WebElement Edit_Profile; 
	
	@FindBy(id="profile_password0")
	private WebElement profilepass; 
	
	@FindBy(id="password1")
	private WebElement pass1;
	
	@FindBy(id="profile_password2")
	private WebElement pass2;
	
	@FindBy(xpath="//button[@id='profile_apply_change']")
	private WebElement SaveSetting;
	 
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
	
	public  void EditProfile() {
		this.Edit_Profile.click(); 
	}
	
	public void Password() {
		this.profilepass.clear();
		this.profilepass.sendKeys("reva123"); 
		this.pass1.clear();
		this.pass1.sendKeys("reva321");
		this.pass2.clear();
		this.pass2.sendKeys("reva321");
		this.SaveSetting.click();
	}
}
