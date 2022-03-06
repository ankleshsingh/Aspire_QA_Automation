package com.aspire.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aspire.page.common.BasePage;

/**
 * This Class is have Login Screen related Locators and respective methods
 * 
 * @author Anklesh Singh
 *
 */
public class LoginPage extends BasePage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@id='login']")
	WebElement weLoginEditBox;

	@FindBy(xpath = "//input[@id='password']")
	WebElement wePasswordEditBox;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement weLoginButton;

	@FindBy(xpath = "//div[text()='Inventory']")
	WebElement weInventoryLabel;

	@FindBy(xpath = "//img[contains(@class,'user')]")
	WebElement weUserLabel;

	@FindBy(xpath = "//a[text()='Log out']")
	WebElement weLogoutLink;

	/**
	 * To check Login page 
	 * 
	 * @author Anklesh Singh
	 *
	 */
	public void checkLoginPage() {
		Assert.assertEquals(checkWebElementExist(weLoginEditBox), true);
	}
	/**
	 * To Login on Web App based on credentials passed
	 * @param sLoginID
	 * @param sLoginPassword
	 * @author Anklesh Singh
	 *
	 */
	
	public void login(String sLoginID, String sLoginPassword) {
		checkLoginPage();
		setData(weLoginEditBox, sLoginID);
		setData(wePasswordEditBox, sLoginPassword);
		clickOnElement(weLoginButton);
	}
	/**
	 * To Log out of App
	 * @author Anklesh Singh
	 *
	 */
	
	public void logout() {
		clickOnElement(weUserLabel);
		clickOnElement(weLogoutLink);
		checkLoginPage();
	}
	/**
	 * To Check Inventory Label exists or not
	 * @author Anklesh Singh
	 *
	 */
	
	public void checkInventoryLabelExist() {
		Assert.assertEquals(checkWebElementExist(weInventoryLabel), true);
	}

}
