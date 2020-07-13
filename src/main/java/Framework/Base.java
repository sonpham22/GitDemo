package Framework;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Base {
	
	public static AndroidDriver<AndroidElement> driver;
	public static AppiumDriverLocalService service;
	
	public AppiumDriverLocalService startServer()
	{
		boolean flag = checkIfServerIsRunning(4723);
		if (!flag)
		{
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;
	}
	
	public static boolean checkIfServerIsRunning(int port)
	{
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try
		{
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		}
		catch (IOException e)
		{
			isServerRunning = true;
		}
		finally
		{
			serverSocket = null;
		}
		return isServerRunning;
	}
	
	public static void startEmulator() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\startEmulator.bat");
		Thread.sleep(6000);
	}

	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException
	{
		Utilities utilities = new Utilities(driver);
		File f = new File("src");
		File fs = new File(f, utilities.GetParam(appName));
		DesiredCapabilities cap = new DesiredCapabilities();
		//String device = (String) prop.get("device");
		String device = System.getProperty("deviceName");
		if (device.contains("SON-PHONE"))
		{
			startEmulator();
		}
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);	
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
	
	public static void getScreenshot(String s) throws IOException
	{
		File scrfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir")+"\\SreenShot\\"+s+".png"));
	}

}
