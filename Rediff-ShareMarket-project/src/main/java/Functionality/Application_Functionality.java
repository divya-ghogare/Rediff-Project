package Functionality;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Application_Functionality extends Validation_Functionality {


	public Application_Functionality() throws IOException {

		// file-1:
		fis = new FileInputStream(projectpath + "\\src\\main\\java\\Properties_File\\environment.properties");
		envprop = new Properties();
		envprop.load(fis);

		// file-2:
		fis = new FileInputStream(projectpath + "\\src\\main\\java\\Properties_File\\locators.properties");
		loctorprop = new Properties();
		loctorprop.load(fis);

		// file-3:
		fis = new FileInputStream(projectpath + "\\src\\main\\java\\Properties_File\\UAT.properties");
		uatprop = new Properties();
		uatprop.load(fis);
	}
	public ExtentReports CreateExtentReport() {
		
		ExtentSparkReporter reports=new ExtentSparkReporter(projectpath+"\\Reports\\rediff.html");
		reports.config().setDocumentTitle("Automation reports");
		reports.config().setReportName("functional testing");
		reports.config().setTheme(Theme.STANDARD);
		
		ExtentReports rep=new ExtentReports();
		rep.attachReporter(reports);
			
		rep.setSystemInfo("OS", "window");

		rep.setSystemInfo("QA", "divya ghogare");

		rep.setSystemInfo("browser", "chrome");
        return rep;
	
	}
	
	//to check portfolio name is present or not:
	public void CheckSelectOptioninDropdown(String locator, String option) {
		Select s=new Select(getelement(locator));
		String text = s.getFirstSelectedOption().getText();
		
		if(text.equalsIgnoreCase(text)) {
			test.log(Status.INFO, "selected option is:-"+option);
		}
		}
	
	//to select option for delete portfolio:
	public void SelectPortfolioName(String locator, String option) {
		s=new Select(getelement(locator));
		s.selectByVisibleText(option);
	}
	
	//to check option is not available:
	public void checkSelectedOptioninDrowpdown(String locator, String option) {
		String text = s.getFirstSelectedOption().getText();
		
		if(text.equalsIgnoreCase(text)) {
			test.log(Status.INFO, "option is ot present:-"+option);
			
		}
	}
	
	//to habndle alert:
	public void acceptAlert() {
		test.log(Status.INFO, "switching towards alert..");
		
		//to wait for alert box:
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
		
		//to switch alert:
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();   //to switch again on prev page
		
		test.log(Status.INFO, "accepted alert..");
		
	}
	
	//to scrollpage:
	public void scrollpage() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	//to add screenshot in report:
	public void add_screenshot(String name) {
		test.addScreenCaptureFromPath(projectpath+"\\Screenshot\\"+name+".png");
	}
	
	
	
}
