package package1Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderTesting {
	
	@DataProvider(name="names")
	public Object[][] dpMethod() {
		return new Object[][] {{"Shafkat"}, {"Ali"}, {false}, {33}};
	}
	
	
	@Test(dataProvider="names")
	public void myTets(Object val) {
		System.out.println("The parameter being passed is: ---> " + val);
	}
	
	

}
