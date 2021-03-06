package com.aspire.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.aspire.page.common.BasePage;

public class ManufacturingPage  extends BasePage{
	private WebDriver driver;
	public ManufacturingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	@FindBy(xpath = "//div[text()='Manufacturing']")
	WebElement weManufacturingLink;
	
	@FindBy(xpath = "//button[contains(text(),'Create')]")
	WebElement weCreateButton;
	
	@FindBy(xpath = "//div[@name='product_id']//input")
	WebElement weProductIDEditbox;
	
	@FindBy(xpath = "//span[contains(text(),'Confirm')]")
	WebElement weConfirmButton;
	
	@FindBy(xpath = "//button[@class='btn btn-primary']/span[text()='Mark as Done']")
	WebElement weMarkAsDoneButton;
	
	@FindBy(xpath = "//span[text()='Ok']")
	WebElement weOkButton;
	
	@FindBy(xpath = "//span[text()='Apply']")
	WebElement weApplyButton;
	
	@FindBy(xpath = "//span[@name='name']")
	WebElement weProductNameLabel;
	
	@FindBy(xpath = "//button[contains(text(),'Save')]")
	WebElement weSaveButton;
	
	/**
	 * To Navigate to Manufacturing page and validate Create button existence
	 * @author Anklesh Singh
	 *
	 */
	
	public void navigateToManufacturingPage() {
		clickOnElement(weManufacturingLink);
		Assert.assertEquals(checkWebElementExist(weCreateButton),true);
	}
	
	/**
	 * To Create Manufacturing entry
	 * @param sProductName
	 * @author Anklesh Singh
	 *
	 */
	
	public void createManufaturingData(String sProductName) throws InterruptedException {
		clickOnElement(weCreateButton);
		setData(weProductIDEditbox, sProductName);
		Thread.sleep(2000);
		clickOnElement(weConfirmButton);
		clickOnElement(weMarkAsDoneButton);
		clickOnElement(weOkButton);
		clickOnElement(weApplyButton);
		Assert.assertEquals(checkWebElementExist(weProductNameLabel), true);
		clickOnElement(weSaveButton);
	}
}
