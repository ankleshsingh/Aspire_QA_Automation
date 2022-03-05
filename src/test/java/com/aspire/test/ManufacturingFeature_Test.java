package com.aspire.test;

import org.testng.annotations.Test;

import com.aspire.baseUtil.BaseTest;
import com.aspire.page.LoginPage;
import com.aspire.page.ManufacturingPage;

public class ManufacturingFeature_Test extends BaseTest{
	private static final String sValidUserName = "user@aspireapp.com";
	private static final String sValidPassword = "@sp1r3app";
	
	LoginPage login;
	ManufacturingPage manufacturing;
	@Test(description = "Test to Create Inventory with Qunatity greater than 10")
	void createInventory() throws InterruptedException {
		loginFunc(sValidUserName, sValidPassword);
		login.checkInventoryLabelExist();
		manufacturing=new ManufacturingPage(driver);
		manufacturing.navigateToManufacturingPage();
		manufacturing.createManufaturingData("TestButter");
		login.logout();
	}
	
	private void loginFunc(String sUserName,String sPassword) {
		login=new LoginPage(driver);
		login.login(sUserName,sPassword);
	}
	
	
}
