package Verify_Functionality;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Portfolio_Managament extends Actual_BaseClass{
  @Test(priority = 1)
  public void Create_Portfolio() {
	  String portfolioname = "john";
	  test.log(Status.INFO, "create Portfolio..");
	  ap.Click("createprtfolio_xpath");
	  ap.clear("portfolioname_cssSelector");
	  ap.Type("portfolioname_cssSelector", "portfolioname");
	  ap.Click("createportfoliobtn_id");
	  
	  ap.CheckSelectOptioninDropdown("portfoliodropdown_id", portfolioname);
	  
  }
  
  @Test(priority = 2)
  public void Delete_Portfolio() {
	 String option="just do";
	 String option_1="john";
	 
	 //to generate log:
	 test.log(Status.INFO, "Delete Portfolio..");
	 ap.SelectPortfolioName("portfoliodropdown_id", option_1);
	 ap.Click("deleteportfoliobtn_id");
	 ap.acceptAlert();
	 
	 ap.checkSelectedOptioninDrowpdown("portfoliodropdown_id", option_1);

  }
  
  @Test(priority = 3)
  public void Update_Portfolio() {
	  System.out.println("Update_Portfolio");

  }
}
