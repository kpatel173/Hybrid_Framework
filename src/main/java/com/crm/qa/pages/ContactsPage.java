package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(linkText = "Create")
	WebElement newContactLink;
	
	@FindBy(xpath = "//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	//changed to identifier but haven't change in data 
	@FindBy(name="identifier")
	WebElement company;
	
	@FindBy(name="category")
	WebElement Category;
	
	@FindBy(xpath = "//i[@class='save icon']")
	WebElement saveBtn;
	
	
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		WebElement check = driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='']//preceding-sibling::td[@class='']//div[@class='ui fitted read-only checkbox']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", check);
	}
	
	public void clickOnNewContactLink(){
		
		newContactLink.click();
		
	}
	public void createNewContact(String category, String ftName, String ltName, String comp){

		Category.click();
		driver.findElement(By.xpath("//span[text()='"+category+"']")).click();
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
		
	}

}
