package com.aspire.base;

/**
 * This Class is for Constants.
 *
 * @author Anklesh Singh
 */
public class Constants {

	/** The Constant WORKING_DIRECTORY. */
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

	/** The Constant REPORT_DIRECTORY. */
	public final static String REPORT_DIRECTORY = WORKING_DIRECTORY + "/ExtentReports/AutomationResult.html";

	/** The Constant EXCEL_DIRECTORY. */
	public final static String EXCEL_DIRECTORY = WORKING_DIRECTORY + "/src/resources/excelDataFiles";

	/** The Constant PROJECT_NAME. */
	public final static String PROJECT_NAME = "Aspire QA Automation by Anklesh";

	/** The Constant EXTENT_CONFIG_PATH. */
	public final static String EXTENT_CONFIG_PATH = WORKING_DIRECTORY + "/src/resources/extent-config.xml";

	/** The Constant PROPERTY_FILE_PATH. */
	public final static String PROPERTY_FILE_PATH = WORKING_DIRECTORY + "/src/resources/TestDefault.properties";
}
