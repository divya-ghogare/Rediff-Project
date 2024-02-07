package Verify_Functionality;

import java.io.IOException;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Functionality.Application_Functionality;

public class Actual_BaseClass {
	public Application_Functionality ap;
	public ExtentReports rep;
	public ExtentTest test;
	
	@BeforeMethod
	public void beforemethod(ITestContext context) throws IOException {
		//pass ap variable:
		ap=(Application_Functionality)context.getAttribute("ap");
		test=(ExtentTest)context.getAttribute("test");
		
	}
	
	@BeforeTest
	public void beforetest(ITestContext context) throws IOException {
		
		ap=new Application_Functionality();
		context.setAttribute("ap", ap);
		
		//initialize report:
		rep=ap.CreateExtentReport();
		
		//create test proprties:
		test=rep.createTest("Do Login");
		
		//pass test refrnce variable:
		context.setAttribute("test", test);
		
		ap.setlog(test);
		
	}
	
	@AfterTest
	public void aftertest() {
		rep.flush();
	}

}
