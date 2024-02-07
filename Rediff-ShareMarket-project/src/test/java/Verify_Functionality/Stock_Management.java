package Verify_Functionality;

import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Stock_Management extends Actual_BaseClass{
  @Test
  public void Add_Stock() {
	  String prtfolioname="Peter";
	  test.log(Status.INFO, "Add_Stock..");
	  ap.SelectPortfolioName("portfoliodropdown_id", prtfolioname);
	  ap.scrollpage();
	  ap.Click("addstockbtn_cssSelector");
  }
  
  @Test
  public void Upadte_Stock() {
	  System.out.println("Upadte_Stock");
  }

  
  @Test
  public void Delete_Stock() {
	  System.out.println("Delete_Stock");

  }
  
  @Test
  public void Verify_Stock() {
	  System.out.println("Verify_Stock");

  }
}
