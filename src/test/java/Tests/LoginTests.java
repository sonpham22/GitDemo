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
	String invalidUserName = "invalidUserName@travel2pay.com";
	String invalidPassWord= "invalidPassWord@travel2pay.com";
	String invalidFormat="invalidFormat";
	String inCompleteFormat="inComlidFormat@";
	
	@Test
	public void LoginWithValidUser() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser(userName, passWord);
		PayNow payNow = new PayNow(driver);
		Assert.isTrue(payNow.PayNowOption().isDisplayed(), "There is no Invalid error message");		
	}
	
	@Test
	public void NotFillOutUserNameAndPass() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser("", "");
		Assert.isTrue(login.InvalidMessage().isDisplayed(), "There is no Invalid error message");
		Assert.isTrue(login.FillOutEmailMessage().isDisplayed(), "There is no fill out email error message");
	}
	
	@Test
	public void NotFillOutUserName() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser("", passWord);
		Assert.isTrue(login.InvalidMessage().isDisplayed(), "There is no Invalid error message");
		Assert.isTrue(login.FillOutEmailMessage().isDisplayed(), "There is no fill out email error message");
	}
	
	@Test
	public void NotFillOutPass() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser(userName, "");
		Assert.isTrue(login.InvalidMessage().isDisplayed(), "There is no Invalid error message");
		//Assert.isTrue(login.FillOutPassMessage().isDisplayed(), "There is no fill out pass word error message");
	}
	
	@Test
	public void InvalidUser() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser(invalidUserName, passWord);
		Assert.isTrue(login.InvalidMessage().isDisplayed(), "There is no Invalid error message");
	}
	
	@Test
	public void InvalidPass() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser(userName, invalidPassWord);
		Assert.isTrue(login.InvalidMessage().isDisplayed(), "There is no Invalid error message");
	}
	
	@Test
	public void InValidUserAndPass() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser(invalidUserName, invalidPassWord);
		Assert.isTrue(login.InvalidMessage().isDisplayed(), "Login successfully with invalid user");		
	}
	
	@Test
	public void InvalidFormat() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser(invalidFormat, passWord);
		Assert.isTrue(login.InvalidFormat().isDisplayed(), "There is no invalid format error message");		
	}
	
	@Test
	public void InCompleteFormat() throws IOException, InterruptedException
	{			
		Login login = new Login(driver);
		login.LoginWithTheUser(inCompleteFormat, passWord);
		Assert.isTrue(login.InCompleteFormat().isDisplayed(), "There is no invalid format error message");		
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
	public void StopServer() throws IOException, InterruptedException
	{
		service.stop();
	}
}
