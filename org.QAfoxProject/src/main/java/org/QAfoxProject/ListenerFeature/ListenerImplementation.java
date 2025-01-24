package org.QAfoxProject.ListenerFeature;

import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.QAfoxProject.GenericUtility.BaseConfiguration;
import org.QAfoxProject.GenericUtility.WebDriverLibrary;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenerImplementation extends BaseConfiguration implements ITestListener ,IRetryAnalyzer{

	@Override
	public void onTestStart(ITestResult result) {
		
		Reporter.log("onTestStart",true);
	}

	@Override
	public boolean retry(ITestResult result) {
		
		
		
		int count = 1;
		int retryuntil = 2;
		boolean flag = false;
		
		
		if(count < retryuntil)
		{
			Reporter.log("Retry...!",true);
			count++;
			flag=true;
		}
		
		return flag;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		Reporter.log("onTestSuccess",true);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		Reporter.log("onTestFailure",true);
		
		//fetch the test method name
		String methodname = result.getName();
		
		//perform typecasting
		TakesScreenshot ts = (TakesScreenshot)WebDriverLibrary.static_driver;
		
		//call the screenshot method
		
		//store the screenshot in temp path
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		//using timestamp
		String timestamp = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss").format(new Date());
		
		
		//create permanent path
		File destination = new File("./TestScreenshot/"+methodname + javautilityobj.getCurrentTime() +".png");
		
		//copy the screenshot from temp to permanent path
		try {
			org.openqa.selenium.io.FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		Reporter.log("onTestSkipped",true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		Reporter.log("onTestFailedButWithinSuccessPercentage",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

		Reporter.log("onTestFailedWithTimeout",true);
	}

	@Override
	public void onStart(ITestContext context) {
		
		Reporter.log("onStart",true);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		Reporter.log("onFinish",true);
	}
	
}
