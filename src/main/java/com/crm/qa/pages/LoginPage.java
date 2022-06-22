package com.crm.qa.pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;



public class LoginPage extends TestBase{
	
	@FindBy(name= "email")
	public WebElement emails;
	
	@FindBy(name= "password")
	public WebElement pass;
	
	@FindBy(xpath= "//div[text()='Login']")
	public WebElement loginButton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	@FindBy(linkText = "Login")
	public WebElement loginlink;
	
	@FindBy(xpath= "//p[contains(text(),'Invalid login')]")
	public WebElement loginErr;
	
	public LoginPage() {
		 PageFactory.initElements(driver, this);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String email, String password) {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();" , loginlink);
		 //loginlink.click();
		 emails.sendKeys(email);
		 pass.sendKeys(password);
		 loginButton.click();
		 return new HomePage();
		 
		
	}
	public String getLoginErr() {
		
		return loginErr.getText();
	}
	
	public void closeBrowser() {
		driver.quit();
		
	}
}