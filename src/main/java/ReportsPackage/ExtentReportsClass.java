package ReportsPackage;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportsClass {

	private static ExtentReports report;
	
	public static ExtentReports getReportInstance(){
		if(report==null) {
			String reportName="Test"+DateUtils.getTimeStamp()+".html";
			System.out.println(reportName);
			ExtentHtmlReporter htmlreporter= new ExtentHtmlReporter("C://Users//Vaibhav//eclipse-workspace//test1//test-output//old//Default suite//"+reportName);
			report= new ExtentReports();
			report.attachReporter(htmlreporter);
			
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Browser", "Chrome");

			htmlreporter.config().setDocumentTitle("Automation Results");
			htmlreporter.config().setReportName("Headlines Test Reports");
			htmlreporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlreporter.config().setTimeStampFormat("MM-dd-yyyy HH:mm:ss");
			}
		
		return report;
	
	}
}
