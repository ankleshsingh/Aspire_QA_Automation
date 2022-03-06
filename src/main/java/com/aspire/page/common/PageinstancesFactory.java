package com.aspire.page.common;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;

import com.aspire.base.WebDriverContext;

/**
 * A factory for creating Pageinstances objects.
 * 
 * @author Anklesh Singh
 */
public class PageinstancesFactory {

	/**
	 * Gets the single instance of PageinstancesFactory.
	 * 
	 * @author Anklesh Singh
	 * @param <T>  the generic type
	 * @param type the type
	 * @return single instance of PageinstancesFactory
	 */
	public static <T extends BasePage> T getInstance(Class<T> type) {
		try {
			return type.getConstructor(WebDriver.class).newInstance(WebDriverContext.getDriver());
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			return null;
		}
	}
}
