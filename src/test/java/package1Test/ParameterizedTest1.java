package package1Test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizedTest1 {
	
	
	@Test
	@Parameters("myName")
	public void paratmeterTest(String myName) {
		
		System.out.println("Parameterized value is : " + myName);
		
	}
	
	
	
	

}
