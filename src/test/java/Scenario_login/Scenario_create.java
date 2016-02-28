package Scenario_login;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Generic_component.Base_Class;
import Generic_component.Utility_Class;
//import Pageobject_login.HomePage;
import Pageobject_login.Pageobject_HomePage;
import Pageobject_login.Pageobject_login;

public class Scenario_create extends Base_Class{

	SoftAssert sAssert= new SoftAssert();
	static Logger log=Logger.getLogger(Scenario_create.class);
	Utility_Class c1= new Utility_Class();

	
	@Test(dataProvider="Invalid_Login_test",dataProviderClass=DataProvider_login.DataProvider_login.class)
	public void Invalid_Login_test(String TC_ID,String Order,String Uname,String Pwd,String Exp_Res) throws IOException
	{
		//String uname = c1.Reading_Properties("uname");
		//String pwd = c1.Reading_Properties("pwd");
		log.info("Executing the testcase "+TC_ID+  "  Order of  "+Order);
		//System.out.println("hi");
		initBrowsersession1();
		Pageobject_login lpob= new Pageobject_login(browser);
		lpob.Commonprocesslogin(Uname,Pwd);//, Pwd);
		String Actual_Res = lpob.Invalid_Login_message();		
		sAssert.assertEquals(Exp_Res, Actual_Res);
		
		if(Actual_Res.equals(Exp_Res))
		{
			log.info("Passed as Expected msg was Valid");	
		}
		else
		{
			log.info("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
			sAssert.fail("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
		}
		tearDown();
		sAssert.assertAll();
		log.info("******************************************");			
	}
	
	
	@Test(dataProvider="Valid_Login_test",dataProviderClass=DataProvider_login.DataProvider_login.class)
	public void Valid_Login_test(String TC_ID,String Order,String Uname,String Pwd,String Exp_Res) throws IOException
	{
		
		
		
		
		log.info("Executing the testcase "+TC_ID+  "  Order of  "+Order);
		initBrowsersession1();
		Pageobject_login lpob= new Pageobject_login(browser);
		lpob.Commonprocesslogin(Uname,Pwd);
		String Actual_Res = lpob.Valid_login();		
		sAssert.assertEquals(Exp_Res, Actual_Res);
		
		if(Actual_Res.equals(Exp_Res))
		{
			log.info("Passed as Expected msg was Valid");	
		}
		else
		{
			log.info("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
			sAssert.fail("Failed as Expected msg was "+Exp_Res +"Actual msg was   "+Actual_Res);
		}
		Pageobject_HomePage Home = new Pageobject_HomePage(browser);
		Home.Click_ControlPanel();
		
		
		//tearDown();
		sAssert.assertAll();
		log.info("******************************************");		
		
		
		
	}
	
}
