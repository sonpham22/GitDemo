package practise.AppiumPramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	@DataProvider(name="InputData")
	public Object[][] getDataforEditField()
	{
		Object[][] obj = new Object[][] {{"hello"}, {"fdlfjdklsfj"}};
		return obj;
	}
}
