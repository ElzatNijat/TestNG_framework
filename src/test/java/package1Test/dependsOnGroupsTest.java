package package1Test;

import org.testng.annotations.Test;

public class dependsOnGroupsTest {
	
	
	@Test(groups = "smokeTestSuite")
	public void test1() {
		
		System.out.println("Inside test 1");
		
	}
	
	
	
	@Test(dependsOnGroups="smokeTestSuite")
	public void test2() {
		
		System.out.println("Inside test 2 depends on Groups");
	}
	
	
	
	@Test(groups ="smokeTestSuite")
	public void test3() {
		
		System.out.println("Inside test 3");
	}
	
	

}
