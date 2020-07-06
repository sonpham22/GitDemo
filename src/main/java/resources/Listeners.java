package resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import practise.AppiumPramework.base;

public class Listeners implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String s = result.getName();
		try 
		{
			base.getScreenshot(s);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
