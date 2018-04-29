package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	// Page Factory - OR(Object Repository):
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	// Find by 'input' tag with 'type' attribute 'submit' value
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	// Find by 'button' tag with text 'Sign Up'
	@FindBy(xpath="//button[contains(text(), 'Sign Up')]")
	WebElement signUpBtn;
	
	// Find by 'img' tag with 'class' attribute 'img-responsive' value
	@FindBy(xpath="//img[contains(@class, 'img-responsive')]")
	WebElement crmLogo;
	
	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		// Workaround sleep to not get org.openqa.selenium.WebDriverException: Element is not clickable at point (..., ...).
		try {
	        Thread.sleep((int) (3000));
	    } catch (InterruptedException e) {
	        //
	        e.printStackTrace();
	    }

		loginBtn.click();
		
		return new HomePage();
	}
}
