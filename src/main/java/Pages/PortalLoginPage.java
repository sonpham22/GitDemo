package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PortalLoginPage {
	
	WebDriver webDriver;
	public PortalLoginPage(WebDriver webDriver) {
		// TODO Auto-generated constructor stub
		this.webDriver=webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public void Login(String user, String pass)
	{
		EmailTextBox().sendKeys(user);
		PassWordTextBox().sendKeys(pass);
		SignInButton().click();
	}

	@FindBy(xpath="//*[@name='email']")
	private WebElement EmailTextBox;
	
	public WebElement EmailTextBox()
	{
		System.out.println("Try to get Email text box element");
		return EmailTextBox;
	}
	
	@FindBy(xpath="//*[@name='password']")
	private WebElement PassWordTextBox;
	
	public WebElement PassWordTextBox()
	{
		System.out.println("Try to get password text box element");
		return PassWordTextBox;
	}
	
	@FindBy(xpath="//button[@type='button']")
	private WebElement SignInButton;
	
	public WebElement SignInButton()
	{
		System.out.println("Try to get sign in button element");
		return SignInButton;
	}
}
