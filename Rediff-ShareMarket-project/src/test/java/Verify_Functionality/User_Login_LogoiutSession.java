package Verify_Functionality;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class User_Login_LogoiutSession extends Actual_BaseClass {
  @Test(priority = 1)
  public void Do_Login() throws IOException {
	  test.log(Status.INFO, "login...");
	  ap.OpenBrowser("chromebrowser");
	  
	  ap.Navigate("rediffurl");
	  
	  ap.Click("sighin_xpath");
	  
	  ap.screenshot("signin page");
	  ap.add_screenshot("signin page");
	  
	  ap.Type("username_id", "username");//enter username
	  
	  ap.Type("userpass_xpath", "userpass"); //enter password
	  
	  ap.Click("submitbtn_id"); //click on submit btn
	  ap.screenshot("submitted");
	  ap.add_screenshot("submitted");
	  System.out.println("Do_Login");
  }
  
  @Test(priority = 2)
  public void Do_Logout() {
	  System.out.println("Do_Logout");
  }
}
