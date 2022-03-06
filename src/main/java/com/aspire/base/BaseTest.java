package com.aspire.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.aspire.utils.LoggerUtil;
import com.aspire.utils.TestProperties;
import com.aspire.utils.listeners.LogListener;
import com.aspire.utils.listeners.ReportListener;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * The Class is responsible for Instantiating driver,
 * handling Pre & Post routines
 *
 * @author Anklesh Singh
 */
@Listeners({ ReportListener.class, LogListener.class })
public class BaseTest {
	/** The driver instance. */
	protected WebDriver driver;
	/**
	 * To Initialize Logger and Load All properties
	 * @author Anklesh Singh
	 */
	@BeforeSuite(alwaysRun = true)
	public void globalSetup() {
		LoggerUtil.log("************************** Test Execution Started ************************************");
		TestProperties.loadAllPropertie();
	}

	/**
	 * This method will be called before each class, takes care of Instantiating
	 * driver,navigating to URL and setting context
	 */
	@BeforeClass()
	public void initTest() {
		driver = getDriver(TestProperties.getProperty("Browser"));
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(TestProperties.getProperty("PageLoadTimeout")), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(TestProperties.getProperty("ImplicitlyWait")), TimeUnit.SECONDS);
		driver.get(TestProperties.getProperty("URL"));
		WebDriverContext.setDriver(driver);
	}
	/**
	 * TO get WebDriver based on value specified on TestDefault.properties
	 * @param property
	 * @return {@link WebDriver} instance
	 */
	private WebDriver getDriver(String property) {
		WebDriver driver=null;
		switch(property.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			//Further browsers can be added over here
		}
		return driver;
	}
	/**
	 * This method will be called after each class, takes care of quitting driver
	 */
	
	@AfterClass
	public void tearDownTest() {
		if (driver != null) {
			driver.quit();
		}
	}

}
