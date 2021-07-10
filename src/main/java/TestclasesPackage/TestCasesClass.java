package TestclasesPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import DatadrivernFramework1Test.BaseUIclass;
import ReportsPackage.ExtentReportsClass;

public class TestCasesClass extends BaseUIclass{

	ExtentReports report= ExtentReportsClass.getReportInstance();
	@Test
	public void TestOne() {


		ExtentTest logger= report.createTest("Test One");
		logger.log(Status.INFO, "Initializing browser");
		invokeBrowser("chrome");
		logger.log(Status.INFO, "Opening webpage");
		openURL("WebsiteURL");
		//ScreenshotAteachStep();
		logger.log(Status.INFO, "Clicking on Signin button");
		elementClick("SigninButton_Xpath");
		//ScreenshotAteachStep();
		logger.log(Status.INFO, "Entering userId");
		enterText("UserName_Xpath", "anshulc55@rediffmail.com");
		//ScreenshotAteachStep();

		logger.log(Status.PASS, "Test Executed Succesfully");
	teardown();
	
	//	quitBrowser();
	}
	@AfterTest
	public void endReport() {
		report.flush();
	}

//	@Test(dependsOnMethods="TestOne")
//	public void TestTwo() {
//		invokeBrowser("chrome");
//		openURL("WebsiteURL");
//		elementClick("SigninButton_Id");
//		enterText("UserName_Id", "anshulc55");
//		teardown();
//		//quiteBrowser();
//	}

//	@Test
//	public void TestThree() {
//
//	}
}
