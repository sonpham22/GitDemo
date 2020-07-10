package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login {
	
	
	public Login(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void LoginWithTheUser(String user, String pass)
	{
		EmailTextBox().sendKeys(user);
		PassWordTextBox().sendKeys(pass);
		SignInButton().click();
	}

	@AndroidFindBy(xpath="(//*[@class='android.widget.EditText'])[1]")
	private WebElement EmailTextBox;
	
	public WebElement EmailTextBox()
	{
		System.out.println("Try to get Email text box element");
		return EmailTextBox;
	}
	
	@AndroidFindBy(xpath="(//*[@class='android.widget.EditText'])[2]")
	private WebElement PassWordTextBox;
	
	public WebElement PassWordTextBox()
	{
		System.out.println("Try to get Password text box element");
		return PassWordTextBox;
	}
	
	@AndroidFindBy(xpath="//*[@text='SIGN IN']")
	private WebElement SignInButton;
	
	public WebElement SignInButton()
	{
		System.out.println("Try to get Sign in button element");
		return SignInButton;
	}
	
	@AndroidFindBy(xpath="//*[@text='Error: Username or password invalid']")
	private WebElement InvalidMessage;
	
	public WebElement InvalidMessage()
	{
		System.out.println("Try to get Error message element");
		return InvalidMessage;
	}
	
	@AndroidFindBy(xpath="//*[@text='Please fill out this field.']")
	private WebElement FillOutEmailMessage;
	
	public WebElement FillOutEmailMessage()
	{
		System.out.println("Try to get Fill Out Email Message element");
		return FillOutEmailMessage;
	}
	
	@AndroidFindBy(xpath="//*[@text='Please fill out this field.']")
	private WebElement FillOutPassMessage;
	
	public WebElement FillOutPassMessage()
	{
		System.out.println("Try to get Fill Out Pass Message element");
		return FillOutPassMessage;
	}
	
	@AndroidFindBy(xpath="//*[@text='Please include an '@' in the email address. 'dsfs' is missing an '@'.']")
	private WebElement InvalidFormat;
	
	public WebElement InvalidFormat()
	{
		System.out.println("Try to get Invalid format Message element");
		return InvalidFormat;
	}
	
	@AndroidFindBy(xpath="//*[contains(@text,'Please enter a part following')]")
	private WebElement InCompleteFormat;
	
	public WebElement InCompleteFormat()
	{
		System.out.println("Try to get Incomplete format Message element");
		return InCompleteFormat;
	}

}
