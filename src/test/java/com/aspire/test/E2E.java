package com.aspire.test;

import org.testng.annotations.Test;

import com.aspire.baseUtil.BaseTest;
import com.aspire.page.LoginPage;

public class E2E extends BaseTest{
	LoginPage login;
	@Test
	void Test1() {
		login=new LoginPage(driver);
		login.login("user@aspireapp.com", "@sp1r3app");
	}
	
	@Test
	void Test2() {
		login.logout();
	}
	
	
}
