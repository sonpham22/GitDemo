package Framework;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities extends Base{
	
	AndroidDriver<AndroidElement> driver;
	
	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver = driver;
	}
	
	public void SetupDriver() throws IOException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities("PayPenseApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
		
	public void scrollToText(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}

}
