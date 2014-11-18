import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;


public class TestClass {

	
@BeforeTest
public void before(){
	System.out.println("I am the before test");
}
	
	
//@BeforeMethod
//public void tbeforeMethod(){
//	
//	System.out.println("I am the before method");
//}
//
//@AfterMethod
//public void afterMethod(){
//	
//	System.out.println("I am the after method");
//}

@DataProvider(name="MyProvider")
public Object[][] provide(){
	return new Object[][]{
		{"Panagiotis","Tsiakos"},	
		//{"Eleni","Koureta"}	
	};
}




@Test(priority=1,dataProvider="MyProvider",groups={"First"})
public void test1(String n1,String n2){
	
	System.out.println("I am " + n1 + " "+ n2);
	Reporter.log("I am " + n1 + " "+ n2);
}
	
	
//@Test(priority=2,groups={"Second"})
//public void test2(){
//	
//	try {
//		Thread.sleep(4000);
//	} catch (InterruptedException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	System.out.println("I am the test2 method");
//}
//
//
@Test(priority=3,groups={"First","Second"})
public void test3(){
	
	System.out.println("I am the test3 method");
	Reporter.log("I am the test 3");
}

}
