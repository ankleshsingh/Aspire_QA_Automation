# Aspire_QA_Automation
Aspire QA Automation is a Test Automation framework having test coverage for Login,Inventory and Manufacturing.

## Pre-requisite

1. Eclipse IDE with GIT and TestNG plugin
2. Maven 3.8.4 (with environment path setup)
3. Web Browser Chrome/Firefox/Edge (any one would work)
4. Git setup locally

## Cloning Git Project

##### Command prompt (option 1)
	1. git clone https://github.com/ankleshsingh/Aspire_QA_Automation.git
	
##### Eclipse (option 2)
	1. Copy the GitHub URL https://github.com/ankleshsingh/Aspire_QA_Automation.git
	2. Open Eclipse and choose Import –> Projects from Git (with smart import)
	3. Choose the Clone URI option in the Git import wizard and click Next
	4. Confirm the URI, Host and Repository path parameters and click Next
	5. Choose the Git branches to clone from the remote repository and click Next
	6. Confirm the Directory into which the repository will be cloned and click Next
	7. Choose the Maven project to import into Eclipse from GitHub and click Finish

## Execution of Test Suite
##### Command prompt (option 1)
	1. Navigate to project root directory in command prompt
	2. Type "mvn clean test" and press enter
	After execution summary will look like below
	
	
##### Eclipse (option 2)
	1. Open testng.xml file located at src/resource/testng_suites
	2. Right Click and execute as TestNg Suite

	
## Folder Structure
	1. src>>main>>java>>com>>aspire
		a. base :- this has 3 java files BaseTest,Contants & WebDriverContext which is having codes for Driver handling.
		b. page & page>>common :- POM based structure for each page.
		c. utils :- has utility library for Excel,Logger,Report and TestProperties.
		d. utils>>listeners :- has Logger and Reporter listeners
		e. utils>>reports :- has code of Extent Reports
	2. src>>resource
		a. excelDataFiles:- has excel file which is used as test data 
		b. testng_suites :- TestNG.xml suite files
		c. extent-config.xml :- Extent Report configuration
		d. log4j.xml :- Log4J configuration
		e. TestDefault.properties :- has key value pair for configuring browser,url and login credentials
	3. src>>test>>java>>com>>aspire.test :- Consists of all test scripts , any test case addition, updation,deletion can be done here.
				
		
#### In case of any query/issue reachout @anshsingh81@gmail.com
								

				
