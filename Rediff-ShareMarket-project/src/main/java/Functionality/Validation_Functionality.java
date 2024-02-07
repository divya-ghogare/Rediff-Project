package Functionality;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class Validation_Functionality extends Generic_Functionality {
	
	public void Validate_Title() {
		
	}
	
	public void Validate_Text() {
		
	}

	public void Validate_Element() {
		
	}
	
	public void screenshot(String screenshotname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(projectpath+"\\Screenshot\\"+"screenshotname"+".png");
		FileHandler.copy(src, target);
	}
}
