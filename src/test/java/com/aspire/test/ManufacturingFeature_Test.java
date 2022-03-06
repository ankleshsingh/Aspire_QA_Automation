package com.aspire.test;

import org.testng.annotations.Test;

import com.aspire.base.BaseTest;
import com.aspire.page.LoginPage;
import com.aspire.page.ManufacturingPage;
import com.aspire.page.common.PageinstancesFactory;
import com.aspire.utils.TestProperties;

public class ManufacturingFeature_Test extends BaseTest{
	LoginPage login;
	ManufacturingPage manufacturing;
	@Test(description = "Test to Create Manufacturing record with Product")
	void createManufaturing() throws InterruptedException {
		loginFunc(TestProperties.getProperty("UserName"), TestProperties.getProperty("UserPassword"));
		login.checkInventoryLabelExist();
		manufacturing=new ManufacturingPage(driver);
		manufacturing.navigateToManufacturingPage();
		manufacturing.createManufaturingData("TestCheese2");
		login.logout();
	}
	
	private void loginFunc(String sUserName,String sPassword) {
		login=PageinstancesFactory.getInstance(LoginPage.class);
		login.login(sUserName,sPassword);
	}
}
