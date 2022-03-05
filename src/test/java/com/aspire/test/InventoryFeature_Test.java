package com.aspire.test;

import org.testng.annotations.Test;

import com.aspire.baseUtil.BaseTest;
import com.aspire.page.InventoryPage;
import com.aspire.page.LoginPage;

public class InventoryFeature_Test extends BaseTest{
	private static final String sValidUserName = "user@aspireapp.com";
	private static final String sValidPassword = "@sp1r3app";
	
	LoginPage login;
	InventoryPage inventory;
	@Test(description = "Test to Create Inventory with Qunatity greater than 10")
	void createInventory() {
		loginFunc(sValidUserName, sValidPassword);
		login.checkInventoryLabelExist();
		inventory=new InventoryPage(driver);
		inventory.navigateToInventryPage();
		inventory.navigateToProductsPage();
		inventory.createNewProduct("TestButter", "11");
		login.logout();
	}
	
	@Test(description = "Test to Create Inventory with Qunatity lesser than 10")
	void createInventoryWithlessQty() {
		loginFunc(sValidUserName, sValidPassword);
		login.checkInventoryLabelExist();
		inventory=new InventoryPage(driver);
		inventory.navigateToInventryPage();
		inventory.navigateToProductsPage();
		inventory.createNewProduct("TestButter1", "5");
		login.logout();
	}
	
	@Test(description = "Test to Create Inventory with Qunatity lesser than 0")
	void createInventoryNegativeQty() {
		loginFunc(sValidUserName, sValidPassword);
		login.checkInventoryLabelExist();
		inventory=new InventoryPage(driver);
		inventory.navigateToInventryPage();
		inventory.navigateToProductsPage();
		inventory.createNewProduct("TestButter1", "-5");
		login.logout();
	}
	
	private void loginFunc(String sUserName,String sPassword) {
		login=new LoginPage(driver);
		login.login(sUserName,sPassword);
	}
	
	
}
