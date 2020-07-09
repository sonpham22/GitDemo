package Tests;

import org.springframework.util.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.Base;
import Framework.Utilities;
import Pages.Login;
import Pages.PayNow;
import java.io.IOException;

public class LoginTests extends Base {
	
	String userName = "son.pham@travel2pay.com";
	String passWord= "son.pham@travel2pay.com";
	String invalidUserName = "invalidUserName";
	String invalidPassWord= "invalidPassWord";
	
	@Test
	public void LoginWithValidUser() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser(userName, passWord);
		PayNow payNow = new PayNow(driver);
		Assert.isTrue(payNow.PayNowOption().isDisplayed(), "Login not successfully");		
	}
	
	@Test
	public void LoginWithInValidUser() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser(invalidUserName, invalidPassWord);
		Assert.isTrue(login.ErrorMessage().isDisplayed(), "Login successfully with invalid user");		
	}
	
	@BeforeTest
	public void killAllNodeAndStartServer() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	@BeforeMethod
	public void StartServer() throws IOException, InterruptedException
	{
		service = startServer();
		Utilities utilities = new Utilities(driver);
		utilities.SetupDriver();
	}
}
