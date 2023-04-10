package package1Test;

import org.testng.annotations.Test;

public class IgnoreTest {
	
	String message = "Juret Aka";
	String name = "Rimer";

	@Test(enabled = false)
	public void testPrint() {
		System.out.println(message);
	}
	
	
	@Test
	public void testPrint2() {
		System.out.println("Second Test ----" + name);
	}	
	
	
	
	
	

}
