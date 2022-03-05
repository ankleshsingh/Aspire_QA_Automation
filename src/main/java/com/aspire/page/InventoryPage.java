package com.aspire.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aspire.baseUtil.GenericUtility;

public class InventoryPage extends GenericUtility{
	public InventoryPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//div[text()='Inventory']")
	WebElement weInventoryLabel;
	
	@FindBy(xpath = "//span[contains(text(),'Inventory Overview')]")
	WebElement weInventoryOverviewLabel;
	
	@FindBy(xpath = "//span[text()='Products']")
	WebElement weProductsTab;
	
	@FindBy(xpath = "//a[text()='Products']")
	WebElement weProductsLink;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement weCreateButton;
	
	@FindBy(xpath = "//input[@name='name']")
	WebElement weProductNameEditbox;
	
	@FindBy(xpath = "//span[text()='Update Quantity']")
	WebElement weUpdateQuantityLink;

	@FindBy(xpath = "//input[@name='inventory_quantity']")
	WebElement weInventoryQtyEditbox;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement weSaveButton;
	
	@FindBy(xpath = "//span[@name='name']")
	WebElement weProductNameLabel;
	
	@FindBy(xpath = "//a[@title='Home menu']")
	WebElement weHomeMenuLink;
	
	@FindBy(xpath = "//div[text()='Manufacturing']")
	WebElement weManufacturingLink;

	public void navigateToInventryPage() {
		clickOnElement(weInventoryLabel);
		Assert.assertEquals(checkWebElementExist(weInventoryOverviewLabel),true);
	}
	
	public void navigateToProductsPage() {
		clickOnElement(weProductsTab);
		clickOnElement(weProductsLink);
		Assert.assertEquals(checkWebElementExist(weCreateButton),true);
	}
	
	public void createNewProduct(String sProductName,String sProductQty) {
		clickOnElement(weCreateButton);
		setData(weProductNameEditbox, sProductName);
		clickOnElement(weUpdateQuantityLink);
		clickOnElement(weCreateButton);
		setData(weInventoryQtyEditbox, sProductQty);
		clickOnElement(weSaveButton);
		clickOnElement(driver.findElement(By.linkText(sProductName)));
		Assert.assertEquals(weProductNameLabel.getText(), sProductName);
	}
}
