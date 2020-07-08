package Resources;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Framework.Base;

public class Listeners implements ITestListener {
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String s = result.getName();
		try 
		{
			Base.getScreenshot(s);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

}
