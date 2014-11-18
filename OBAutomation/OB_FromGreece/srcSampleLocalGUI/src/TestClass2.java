import org.testng.Reporter;
import org.testng.annotations.*;


public class TestClass2 {

	
	
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

@Test(groups={"First"})
public void test11(){
	
	System.out.println("I am the test11 method");
	Reporter.log("I am the test 11");
}
	
	
@Test(invocationTimeOut=3000)
public void test22(){
	
	Reporter.log("I am the test 22");
	System.out.println("I am the test22 method");
}


}
