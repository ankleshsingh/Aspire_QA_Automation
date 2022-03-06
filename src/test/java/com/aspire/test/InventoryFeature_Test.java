package com.aspire.test;

import org.testng.annotations.Test;

import com.aspire.base.BaseTest;
import com.aspire.page.InventoryPage;
import com.aspire.page.LoginPage;
import com.aspire.utils.ExcelUtil;
import com.aspire.utils.TestProperties;

public class InventoryFeature_Test extends BaseTest{
	LoginPage login;
	InventoryPage inventory;
	@Test(dataProvider = "getInventoryData", dataProviderClass=ExcelUtil.class, description = "Test to Create Inventory with various Qunatity")
	void createInventory(String sProductName,String sProductValue) {
		loginFunc(TestProperties.getProperty("UserName"), TestProperties.getProperty("UserPassword"));
		login.checkInventoryLabelExist();
		inventory=new InventoryPage(driver);
		inventory.navigateToInventryPage();
		inventory.navigateToProductsPage();
		inventory.createNewProduct(sProductName, sProductValue);
		login.logout();
	}
	
	private void loginFunc(String sUserName,String sPassword) {
		login=new LoginPage(driver);
		login.login(sUserName,sPassword);
	}
}
