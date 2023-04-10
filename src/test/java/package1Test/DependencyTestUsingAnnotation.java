package package1Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyTestUsingAnnotation {
	
	@Test
	public void test1() {
		
		System.out.println("Inside test 1");
		Assert.assertTrue(false);
	}
	
	
	
	@Test(dependsOnMethods = {"test1"})
	public void test2() {
		
		System.out.println("Inside test 2");
	}
	
	
	
	@Test()
	public void test3() {
		
		System.out.println("Inside test 3");
	}
	
	
	

}
