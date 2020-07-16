package AppPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AppPayNowPage {
	
	
	public AppPayNowPage(AndroidDriver<AndroidElement> driver) 
	{
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@AndroidFindBy(xpath="//*[@text='credit_card Pay Now']")
	private WebElement PayNowOption;
	
	public WebElement PayNowOption()
	{
		System.out.println("Try to get Pay Now Option element");
		return PayNowOption;
	}	
}
