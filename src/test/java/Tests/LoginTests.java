package Tests;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.Base;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import java.io.IOException;

public class LoginTests extends Base {
	
	@Test
	public void LoginWithValidUser() throws IOException, InterruptedException
	{
		service = startServer();
		
		AndroidDriver<AndroidElement> driver = Capabilities("PayPenseApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		service.stop();
		
	}
	
	@BeforeTest
	public void killAllNode() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
}
