package Pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	
	public FormPage(AndroidDriver<AndroidElement> driver) 
	{
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(xpath="//*[@text='Female']")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="android:id/text1")
	private WebElement countrySelection;
	
	public WebElement getNameField()
	{
		System.out.println("trying to find the Name field");
		return nameField;
	}
	
	public WebElement selectFemaleOption()
	{
		System.out.println("Selecting the female option");
		return femaleOption;
	}
	
	public WebElement selectCountry()
	{
		System.out.println("Selecting the option from dropdown");
		return countrySelection;
	}
}