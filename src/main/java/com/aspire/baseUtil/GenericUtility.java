package com.aspire.baseUtil;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class GenericUtility{
	private final int FLUENT_WAIT_TIMEOUT = 30;
	private final int FLUENT_WAIT_POLL= 5;
	protected WebDriver driver = null;
//	private WebDriver driver;
//	public GenericUtility(WebDriver driver) {
//		this.driver=driver;
//	}
//	public GenericUtility() {
//		super();
//	}
	
	public GenericUtility(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private void waitForElementExistance(WebElement we) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(FLUENT_WAIT_TIMEOUT))
				.pollingEvery(Duration.ofSeconds(FLUENT_WAIT_POLL));
		wait.until(ExpectedConditions.visibilityOf(we));
	}
	public void setData(WebElement weInput,String sValue) {
		waitForElementExistance(weInput);
		weInput.clear();
		weInput.sendKeys(sValue);
	}
	
	public void clickOnElement(WebElement weInput) {
		waitForElementExistance(weInput);
		weInput.click();
	}
	
	public boolean checkWebElementExist(WebElement we) {
		boolean bFlag=false;
		try {
			waitForElementExistance(we);
			bFlag=true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return bFlag;
	}
}
