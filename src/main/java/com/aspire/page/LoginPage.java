package com.aspire.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aspire.baseUtil.GenericUtility;

public class LoginPage extends GenericUtility{
	public LoginPage(WebDriver driver) {
		super(driver);
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
	
	public void checkLoginPage() {
		Assert.assertEquals(checkWebElementExist(weLoginEditBox),true);
	}
	public void login(String sLoginID,String sLoginPassword) {
		checkLoginPage();
		setData(weLoginEditBox, sLoginID);
		setData(wePasswordEditBox, sLoginPassword);
		clickOnElement(weLoginButton);
	}
	
	public void logout() {
		clickOnElement(weUserLabel);
		clickOnElement(weLogoutLink);
		checkLoginPage();
	}
	
	public void checkInventoryLabelExist(){
		Assert.assertEquals(checkWebElementExist(weInventoryLabel),true);
	}
	
}
