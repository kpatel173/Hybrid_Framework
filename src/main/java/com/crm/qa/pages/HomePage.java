package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

;

public class HomePage extends TestBase{
	
	
	@FindBy(xpath= "//span[contains(text(), 'Krupal Patel')]")
	public WebElement userNameLabel;
	
	@FindBy(xpath = "//i[@class='users icon']")
	WebElement contactsIcon;
	
	
	

	@FindBy(xpath = "//i[@class='money icon']")
	WebElement dealsIcon;

	@FindBy(xpath = "//i[@class='tasks icon']")
	WebElement tasksIcon;
	
	@FindBy(xpath = "//div[@id='top-header-menu']")
	WebElement topbar;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
		contactsIcon.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink(){
		dealsIcon.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksIcon.click();

		return new TasksPage();
	}
	
	public void closeSidePanel(){
		Actions action = new Actions(driver);
		action.moveToElement(topbar).build().perform();
	}
	
	
	
	
	
}