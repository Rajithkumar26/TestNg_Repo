package ExtentReportTest;

import java.util.Date;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ReportCreationclass {

	public static ExtentReports extentreport;

	
@BeforeTest	
	public static ExtentReports createreport() {
	if(extentreport==null)	{
	Date datetime= new Date();
		String reportname= datetime.toString().replaceAll(" ","-");
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter("C://Users//Vaibhav//eclipse-workspace//test1//test-output//old//TodatReportname.html");
	extentreport= new ExtentReports();
		extentreport.attachReporter(htmlreporter);
		
		extentreport.setSystemInfo("OS", "Windows 10");
		extentreport.setSystemInfo("Browser", "Chrome");

		htmlreporter.config().setDocumentTitle("Automation Results");
		htmlreporter.config().setReportName("Headlines Test Reports");
		htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreporter.config().setTimeStampFormat("MM-dd-yyyy HH:mm:ss");
	}	
	return extentreport;	
	
}
	
}
