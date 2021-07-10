package DatadrivernFramework1Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import ReportsPackage.DateUtils;

/**
 * Hello world!
 *
 */
public class BaseUIclass
{

	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest logger;
public Properties properties;
	//opens a browser
	public void invokeBrowser(String browserName) {
		System.out.println("Hello World!");
		System.out.println("Selected Browser: "+browserName);
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vaibhav\\Desktop\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					driver.manage().window().maximize();
					driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		}
		if(properties==null) {
			properties= new Properties();
			try {
				FileInputStream file= new FileInputStream("C://Users//Vaibhav//eclipse-workspace//test1//src//main//resources//ObjectRepository//commonDetails.properties");
			properties.load(file);
				// TODO Auto-generated catch block
			}catch(Exception e) {
			e.printStackTrace();
		}
	}
	}
		
//opens a webpage
	public void openURL(String WebsiteURLkey) {
		System.out.println("Opening webpage: "+WebsiteURLkey);
		driver.get(properties.getProperty(WebsiteURLkey));
	}
//close  the browser
	public void teardown() {
		System.out.println("Closing Browser");
		driver.close();
	}
//quit thebrowser
	public void quitBrowser() {
		System.out.println("Closing multiple browsers");
	driver.quit();
	}
//to enter username
	public void enterText(String xpathkey, String data) {
		System.out.println("Entering username");
getElement(xpathkey).sendKeys(data);
		//driver.findElement(By.xpath(properties.getProperty(xpathkey))).sendKeys(data);

//JavascriptExecutor executor = (JavascriptExecutor)driver;
//executor.executeAsyncScript("window.scrollBy(0,1000)");
//try {
//	Thread.sleep(2000);
//} catch (InterruptedException e) {
//	// TODO Auto-generated catch block
//	e.printStackTrace();
//}
//executor.executeAsyncScript("window.scrollBy(0,-1000)");
	}
	//to click a element
	public void elementClick(String xpathkey) {
		System.out.println("Clicking on Signin button");
		getElement(xpathkey).click();
		//driver.findElement(By.xpath(properties.getProperty(xpathkey))).click();
	}
	
	public WebElement getElement(String locatorkey) {
		WebElement element = null;
		if(locatorkey.endsWith("_Xpath")) {
			element= driver.findElement(By.xpath(properties.getProperty(locatorkey)));
		}
		if(locatorkey.endsWith("_Id")) {
			element= driver.findElement(By.id(properties.getProperty(locatorkey)));
		}
		if(locatorkey.endsWith("_Css")) {
			element= driver.findElement(By.cssSelector(properties.getProperty(locatorkey)));
		}
		return element;
	}
	
	public void ScreenshotAteachStep() {
		TakesScreenshot screen= (TakesScreenshot)driver;
		
		File Srcfile= screen.getScreenshotAs(OutputType.FILE);
		File Destfile=new File("C:\\Users\\Vaibhav\\eclipse-workspace\\test1\\test-output\\Screenshots\\"+DateUtils.getTimeStamp()+".html");
	try {
		FileUtils.copyFile(Srcfile, Destfile);
		logger.addScreenCaptureFromPath("C:\\Users\\Vaibhav\\eclipse-workspace\\test1\\test-output\\Screenshots\\"+ DateUtils.getTimeStamp()+".png");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
	
	
	
	
}
