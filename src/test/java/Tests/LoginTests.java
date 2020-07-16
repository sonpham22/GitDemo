package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.Base;
import Framework.Utilities;
import java.io.IOException;

public class LoginTests extends Base {
	
	String userName = "son.pham@travel2pay.com";
	String passWord= "son.pham@travel2pay.com";
	String invalidUserName = "invalidUserName@travel2pay.com";
	String invalidPassWord= "invalidPassWord@travel2pay.com";
	String invalidFormat="invalidFormat";
	String inCompleteFormat="inComlidFormat@";
	
	@Test
	public void LoginDemo() throws IOException, InterruptedException
	{	
		Utilities webOject = new Utilities(webDriver);
		Utilities androidOject = new Utilities(androidDriver);
		webOject.LoginToPortal();
		androidOject.LoginToApp();
	}
	
	@BeforeTest
	public void KillNode() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void ReOpenApp() throws IOException, InterruptedException
	{
		Utilities web = new Utilities(webDriver);
		web.GetWebDriver();
		service = startServer();
		Utilities android = new Utilities(androidDriver);
		android.GetAndroiddDriver();
	}
	
	@AfterMethod
	public void StopServer()
	{
		service.stop();
	}
}
