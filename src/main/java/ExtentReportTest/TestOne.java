package ExtentReportTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestOne {


	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest logger;
	public Properties properties;
	public ChromeOptions op;
	//opens a browser
public TestOne() {
 properties= new Properties();

try {
	FileInputStream fileIn = new FileInputStream("C://Users//Vaibhav//eclipse-workspace//test1//src//main//resources//ObjectRepository//commonDetails.properties");
	try {
		properties.load(fileIn);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}

}





public void openBrowser() {

//	String browserName= properties.getProperty("browserName");
//	if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vaibhav\\Desktop\\chromedriver.exe"); 
	op= new ChromeOptions();
	driver= new ChromeDriver(op);
//}
			driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	op.setExperimentalOption("useAutomationExtension", false);
	op.setExperimentalOption("excludeSwitches",Collections.singletonList("enable-automation"));
}


public void website() {
driver.get(properties.getProperty("url"));
	
}


public void clickonSign(String uname, String pwd) {
	driver.findElement(By.xpath(properties.getProperty("signInbutton"))).click();
	driver.findElement(By.xpath(properties.getProperty("userName"))).sendKeys(uname);
	driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(pwd);
	driver.findElement(By.xpath(properties.getProperty("password"))).sendKeys(Keys.ENTER);
}


public boolean getHomepageTtitle() {
	return driver.findElement(By.xpath("//a[contains(text(), 'Anshul Chauhan')]")).isDisplayed();
	
}





}
