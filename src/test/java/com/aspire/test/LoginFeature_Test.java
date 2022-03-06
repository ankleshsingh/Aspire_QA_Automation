package com.aspire.test;

import org.testng.annotations.Test;

import com.aspire.base.BaseTest;
import com.aspire.page.LoginPage;
import com.aspire.page.common.PageinstancesFactory;
import com.aspire.utils.TestProperties;

public class LoginFeature_Test extends BaseTest{
//	private static final String sValidUserName = TestProperties.getProperty("UserName");
//	private static final String sValidPassword = TestProperties.getProperty("UserPassword");
	private static final String sInvalidPassword = "@sp1r3app123";
	private static final String sInvalidUserName = "user12@aspireapp.com";
	
	LoginPage login;
	
	@Test(description = "Test to Validate Successful login Sceanrio with valid credentials")
	void validLogin() {
		loginFunc(TestProperties.getProperty("UserName"), TestProperties.getProperty("UserPassword"));
		login.checkInventoryLabelExist();
		login.logout();
	}
	
	@Test(description = "Test to Validate login failure Sceanrio with invalid credentials")
	void inValidLogin() {
		loginFunc(sInvalidUserName, sInvalidPassword);
		login.checkLoginPage();	
	}
	
	@Test(description = "Test to Validate that after logout page not taking to Home page")
	void validLoginLogout() {
		loginFunc(TestProperties.getProperty("UserName"), TestProperties.getProperty("UserPassword"));
		login.checkInventoryLabelExist();
		login.logout();
		this.driver.get("https://aspireapp.odoo.com/web#cids=1&action=menu");
		login.checkLoginPage();
	}
	
	private void loginFunc(String sUserName,String sPassword) {
		login=PageinstancesFactory.getInstance(LoginPage.class);
		login.login(sUserName,sPassword);
	}
}
