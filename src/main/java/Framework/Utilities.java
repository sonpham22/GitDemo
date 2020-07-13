package Framework;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import Pages.LoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities extends Base{
	
	AndroidDriver<AndroidElement> driver;
	
	public String GetParam(String name) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Framework\\Properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(name);
	}
	
	public Utilities(AndroidDriver<AndroidElement> driver)
	{
		this.driver = driver;
	}
	
	public void SetupDriver() throws IOException, InterruptedException
	{
		AndroidDriver<AndroidElement> driver = Capabilities("PayPenseApp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
		
	public void scrollToText(String text)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	public void LoginToApp() throws IOException
	{	
		LoginPage loginPage = new LoginPage(driver);
		loginPage.Login(GetParam("userName"), GetParam("passWord"));
	}
}
