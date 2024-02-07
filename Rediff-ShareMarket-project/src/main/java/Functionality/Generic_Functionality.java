package Functionality;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Generic_Functionality {
	
	public String projectpath = System.getProperty("user.dir");
	public Properties envprop;
	public Properties uatprop;
	public Properties loctorprop;
	public FileInputStream fis;
	public WebDriver driver;
	public ExtentTest test;
	public Select s;
	
	public void OpenBrowser(String browser) {
		System.out.println("launch browser is:"+uatprop.getProperty(browser));
		
		//to generate log:
		test.log(Status.INFO, "launch browser is:"+uatprop.getProperty(browser));
		if(uatprop.getProperty(browser).equalsIgnoreCase("chrome")) {
			//chromebrowser=chrome:
			driver=new ChromeDriver();
			
		}else if (uatprop.getProperty(browser).equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
			
		}else if (uatprop.getProperty(browser).equalsIgnoreCase("edge")){
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void Navigate(String url) {
		System.out.println("Navigate url is:-"+uatprop.getProperty(url));
		
		test.log(Status.INFO, "Navigate url is:-"+uatprop.getProperty(url));
		driver.get(uatprop.getProperty(url));
		
	}
	
	public void Click(String locator) {
		System.out.println(loctorprop.getProperty(locator));
		
		test.log(Status.INFO, "click on webelement is:-"+loctorprop.getProperty(locator));
		getelement(locator).click();
		
	}
	
	public void Gettext() {
		
	}
	
	public void select(String locator, String input_option) {
		
	}
	
	public void Type(String locator, String input_text) {
		
		test.log(Status.INFO, "clicked on webelement is:-"+loctorprop.getProperty(locator));
		
		test.log(Status.INFO, "entered text is:-"+uatprop.getProperty(input_text));
		getelement(locator).sendKeys(uatprop.getProperty(input_text));
	}
	
	public void clear(String locator) {
		test.log(Status.INFO, "cleared webelement is:"+loctorprop.getProperty(locator));
		getelement(locator).clear();
	}
	
	public WebElement getelement(String locatorkey) {
		WebElement element=null;
		element=driver.findElement(getlocator(locatorkey));
		return element;
	}
	
	public By getlocator(String locatorkey) {
		By by=null;
		if(locatorkey.endsWith("_linkText")) {
			by=By.linkText(loctorprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_id")) {
			by=By.id(loctorprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_name")) {
			by=By.name(loctorprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_partiallinktext")) {
			by=By.partialLinkText(loctorprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_xpath")) {
			by=By.xpath(loctorprop.getProperty(locatorkey));
		}
		else if(locatorkey.endsWith("_cssSelector")) {
			by=By.cssSelector(loctorprop.getProperty(locatorkey));
		}
		return by;
			
	}
	// to generate log:
	public void setlog(ExtentTest test) {
		this.test=test;
	}
	
	
	
	
}
