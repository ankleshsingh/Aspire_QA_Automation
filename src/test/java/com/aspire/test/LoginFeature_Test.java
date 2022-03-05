package com.aspire.test;

import org.testng.annotations.Test;

import com.aspire.baseUtil.BaseTest;
import com.aspire.page.LoginPage;

public class LoginFeature_Test extends BaseTest{
	private static final String sValidUserName = "user@aspireapp.com";
	private static final String sValidPassword = "@sp1r3app";
	private static final String sInvalidPassword = "@sp1r3app123";
	private static final String sInvalidUserName = "user12@aspireapp.com";
	
	LoginPage login;
	
	@Test(description = "Test to Validate Successful login Sceanrio with valid credentials")
	void validLogin() {
		loginFunc(sValidUserName, sValidPassword);
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
		loginFunc(sValidUserName, sValidPassword);
		login.checkInventoryLabelExist();
		login.logout();
		driver.get("https://aspireapp.odoo.com/web#cids=1&action=menu");
		login.checkLoginPage();
	}
	private void loginFunc(String sUserName,String sPassword) {
		login=new LoginPage(driver);
		login.login(sUserName,sPassword);
	}
	
	
}
