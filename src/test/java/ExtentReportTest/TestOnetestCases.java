package ExtentReportTest;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class TestOnetestCases extends TestOne {
	public TestOne testone = new TestOne();
	public ReportCreationclass ereports =new ReportCreationclass();
	
	ExtentReports reports=ReportCreationclass.createreport();
	
	
	
	@Test()
	public void testaWebsite() {
		ExtentTest logg= reports.createTest("VerifyTest");
		testone.openBrowser();
		logg.log(Status.PASS, "Chrome Browser launched");
		testone.website();
		logg.log(Status.PASS, "Rediff website opened");
		testone.clickonSign("anshulc55@rediffmail.com", "Test@1234");
		logg.log(Status.PASS, "Signed in to Rediff website");
		boolean flag=  testone.getHomepageTtitle();
		Assert.assertTrue(flag);
		logg.log(Status.PASS, "User name is displayed");
	}
	
	
	@AfterTest
	public void endReport() {
		reports.flush();
	}
	
}
