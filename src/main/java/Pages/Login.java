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
	private WebElement ErrorMessage;
	
	public WebElement ErrorMessage()
	{
		System.out.println("Try to get Error message element");
		return ErrorMessage;
	}

}
