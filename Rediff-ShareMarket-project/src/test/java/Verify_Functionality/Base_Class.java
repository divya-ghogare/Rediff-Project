package Verify_Functionality;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Base_Class {

	public static void main(String[] args) throws IOException {
		String projectpath=System.getProperty("user.dir");
		FileInputStream fis=new FileInputStream(projectpath+"\\src\\main\\java\\Properties_File\\data.properties");
		Properties prop=new Properties();
		prop.load(fis);
		
		//data fetch from propfile:
		prop.getProperty("chromebrowser");
		System.out.println(prop.getProperty("chromebrowser"));
	}

}
