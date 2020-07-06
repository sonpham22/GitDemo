package practise.AppiumPramework;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static io.appium.java_client.touch.offset.ElementOption.element;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.CheckOutPage;
import pageObjects.FormPage;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;
import java.io.IOException;

public class TC4 extends base {
	
	@Test
	public void totalValidation() throws IOException, InterruptedException
	{
		service = startServer();
		
		AndroidDriver<AndroidElement> driver = Capabilities("GeneralStoreApp");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FormPage formPage = new FormPage(driver);
		formPage.getNameField().sendKeys("hello");
		driver.hideKeyboard();
		formPage.selectFemaleOption().click();
		formPage.selectCountry().click();
		Utilities utilities = new Utilities(driver);
		utilities.scrollToText("Argentina");
		driver.findElement(By.xpath("//*[@text='Argentina']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sum = 0;
		CheckOutPage checkOutPage = new CheckOutPage(driver);
		for(int i=0; i<count; i++)
		{
			String amout1 = checkOutPage.productList.get(i).getText();
			double amout = getAmout(amout1);
			sum = sum + amout;
		}
		
		System.out.println(sum + " sum of products");
			
		String total = checkOutPage.totalAmout.getText();
		total = total.substring(2);
		double totalValue = Double.parseDouble(total);
		System.out.println(totalValue + " total value of products");
			
			
		// Mobile Gestures
		WebElement checkbox = driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
			
		WebElement tc = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(tc)).withDuration(ofSeconds(2))).release().perform();
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		
		service.stop();
		
	}
	
	@BeforeTest
	public void killAllNode() throws IOException, InterruptedException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(3000);
	}
	
	public static double getAmout(String value)
	{
		value = value.substring(1);
		double amout = Double.parseDouble(value);
		return amout;
	}
	
	public void testGit()
	{
		System.out.println("hello guys");
		//fjhdsfkjhdsjghdsj
	}
}
