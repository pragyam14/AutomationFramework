package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.Page;



public class Utilities extends Page {

	public static String screenshotPath;
	public static String screenshotName;

	public static void takeScreenshot() throws IOException {
		
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY h:m:s");
        Date date = new Date();
      
		screenshotName = screenshotName + "-" + dateFormat.format(date) + ".png";

		FileUtils.copyFile(sourceFile,
				new File(System.getProperty("user.dir") + "/target/surefire-reports/html/" + screenshotName));

	}

	
}
	
	
	
	

