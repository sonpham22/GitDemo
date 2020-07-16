package Framework;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import Pages.AppLoginPage;
import Pages.PortalLoginPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utilities extends Base{
	
	WebDriver webDriver;
	AndroidDriver<AndroidElement> androidDriver;
	
	public Utilities(WebDriver webDriver)
	{
		this.webDriver = webDriver;
	}
	
	public Utilities(AndroidDriver<AndroidElement> androidDriver)
	{
		this.androidDriver = androidDriver;
	}
	
	public String GetParam(String name) throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Framework\\Properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop.getProperty(name);
	}
	
	public void GetAndroiddDriver() throws IOException, InterruptedException
	{
		AndroidDriver<AndroidElement> androidDriver = AndroidCapabilities("PayPenseApp");
		androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void GetWebDriver()
	{
		webDriver = WebCapabilities();
		webDriver.get("http://ntc.travel2pay.com/");
		webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
		
	public void scrollToText(String text)
	{
		androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");
	}
	
	public void LoginToApp() throws IOException
	{	
		AppLoginPage appLoginPage = new AppLoginPage(androidDriver);
		appLoginPage.Login(GetParam("userName"), GetParam("passWord"));
	}
	
	public void LoginToPortal() throws IOException
	{	
		PortalLoginPage portalLoginPage = new PortalLoginPage(webDriver);
		portalLoginPage.Login(GetParam("userName"), GetParam("passWord"));
	}
}
