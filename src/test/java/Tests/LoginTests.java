package Tests;

import org.springframework.util.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Framework.Base;
import Framework.Utilities;
import Pages.LoginPage;
import Pages.PayNow;
import java.io.IOException;

public class LoginTests extends Base {
	
	String userName = "son.pham@travel2pay.com";
	String passWord= "son.pham@travel2pay.com";
	String invalidUserName = "invalidUserName@travel2pay.com";
	String invalidPassWord= "invalidPassWord@travel2pay.com";
	String invalidFormat="invalidFormat";
	String inCompleteFormat="inComlidFormat@";
	
	@Test
	public void LoginWithValidUser()
	{			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(userName, passWord);
		PayNow payNow = new PayNow(driver);
		Assert.isTrue(payNow.PayNowOption().isDisplayed(), "There is no Invalid error message");		
	}
	
	@Test
	public void NotFillOutUserNameAndPass()
	{			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("", "");
		Assert.isTrue(loginPage.InvalidMessage().isDisplayed(), "There is no Invalid error message");
		Assert.isTrue(loginPage.FillOutEmailMessage().isDisplayed(), "There is no fill out email error message");
	}
	
	@Test
	public void NotFillOutUserName()
	{			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login("", passWord);
		Assert.isTrue(loginPage.InvalidMessage().isDisplayed(), "There is no Invalid error message");
		Assert.isTrue(loginPage.FillOutEmailMessage().isDisplayed(), "There is no fill out email error message");
	}
	
	@Test
	public void NotFillOutPass()
	{			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(userName, "");
		Assert.isTrue(loginPage.InvalidMessage().isDisplayed(), "There is no Invalid error message");
		//Assert.isTrue(login.FillOutPassMessage().isDisplayed(), "There is no fill out pass word error message");
	}
	
	@Test
	public void InvalidUser()
	{			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(invalidUserName, passWord);
		Assert.isTrue(loginPage.InvalidMessage().isDisplayed(), "There is no Invalid error message");
	}
	
	@Test
	public void InvalidPass()
	{			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(userName, invalidPassWord);
		Assert.isTrue(loginPage.InvalidMessage().isDisplayed(), "There is no Invalid error message");
	}
	
	@Test
	public void InValidUserAndPass()
	{			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(invalidUserName, invalidPassWord);
		Assert.isTrue(loginPage.InvalidMessage().isDisplayed(), "Login successfully with invalid user");		
	}
	
	@Test
	public void InvalidFormat()
	{			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(invalidFormat, passWord);
		Assert.isTrue(loginPage.InvalidFormat().isDisplayed(), "There is no invalid format error message");		
	}
	
	@Test
	public void InCompleteFormat()
	{			
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(inCompleteFormat, passWord);
		Assert.isTrue(loginPage.InCompleteFormat().isDisplayed(), "There is no invalid format error message");		
	}
	
	@Test
	public void LoginDemo() throws IOException
	{			
		Utilities utilities = new Utilities(driver);
		utilities.LoginToApp();		
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
		service = startServer();
		Utilities utilities = new Utilities(driver);
		utilities.SetupDriver();
	}
	
	@AfterMethod
	public void StopServer()
	{
		service.stop();
	}
}
