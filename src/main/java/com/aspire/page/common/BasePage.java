package com.aspire.page.common;

import java.time.Duration;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.aspire.utils.ReportUtil;
import com.aspire.utils.TestProperties;
import com.relevantcodes.extentreports.LogStatus;

/**
 * This is Base Page class, which has generic function to interact with Web
 * Elements
 * 
 * @author Anklesh Singh
 *
 */
public class BasePage {
	protected WebDriver driver;
	protected Wait<WebDriver> wait;

	/**
	 * Instantiates a new base page with fluent wait
	 *
	 * @param driver the driver
	 */
	public BasePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new FluentWait<WebDriver>(this.driver)
				.withTimeout(Duration.ofSeconds(Integer.parseInt(TestProperties.getProperty("FLUENT_WAIT_TIMEOUT"))))
				.pollingEvery(Duration.ofSeconds(Integer.parseInt(TestProperties.getProperty("FLUENT_WAIT_POLL"))));
	}

	/**
	 * Wait for Element Existance
	 * 
	 * @author Anklesh Singh
	 * @param we - WebElement
	 */
	private void waitForElementExistance(WebElement we) {
		wait.until(ExpectedConditions.visibilityOf(we));
	}

	/**
	 * Wait for Element Clickable
	 * 
	 * @author Anklesh Singh
	 * @param we - WebElement
	 */
	private void waitForElementClickable(WebElement we) {
		wait.until(ExpectedConditions.elementToBeClickable(we));
	}

	/**
	 * To Set data into input box after clearing the existing values
	 * 
	 * @author Anklesh Singh
	 * @param weInput
	 * @param sValue
	 */
	public void setData(WebElement weInput, String sValue) {
		waitForElementExistance(weInput);
		weInput.clear();
		weInput.sendKeys(sValue);
		ReportUtil.logMessage(LogStatus.PASS, "Set Data Successfully", "Set "+sValue+" Successfully");
	}

	/**
	 * To click on Element Anklesh Singh
	 * 
	 * @param weInput
	 */
	public void clickOnElement(WebElement weInput) {
		try {
			waitForElementClickable(weInput);
			weInput.click();
			ReportUtil.logMessage(LogStatus.PASS, "Click Successfully", "Click Successfully");
		}catch(ElementClickInterceptedException e) {
			clickOnElementJSE(weInput);
		}
	}
	
	/**
	 * To click on Element Anklesh Singh
	 * 
	 * @param weInput
	 */
	public void clickOnElementJSE(WebElement weInput) {
			JavascriptExecutor jse= (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].click();", weInput);
			ReportUtil.logMessage(LogStatus.PASS, "Click on Element using JavascriptExecutor", "Clicked Successfully");
	}
	/**
	 * To check if WebElement exists or not
	 * @param we-WebElement
	 * @return true-if exists else false
	 */
	public boolean checkWebElementExist(WebElement we) {
		boolean bFlag = false;
		try {
			waitForElementExistance(we);
			bFlag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFlag;
	}
}
