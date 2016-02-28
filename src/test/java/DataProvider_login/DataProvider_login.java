package DataProvider_login;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.DataProvider;

import Generic_component.ExcelReadWrite;
public class DataProvider_login{

//1
	@DataProvider(name="Invalid_Login_test")
	public static Iterator<String[]> Invalid_Login_test() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Invalid_Login_test");
		return Obj.iterator();	
	}
	
	@DataProvider(name="Valid_Login_test")
	public static Iterator<String[]> Valid_Login_test() throws IOException
	{
		
		List<String[]> Obj = flagRowCount("Valid_Login_test");
		return Obj.iterator();	
	}
	
	
	
	//to get the flag row count
	public static List<String[]> flagRowCount(String script_name) throws IOException
	{
		//"D:\\akash\\salenium\\Reach_OAMC\\Excel-files\\Branch\\Reachwell_CP_Branch_Data.xls"
		ExcelReadWrite x=new ExcelReadWrite(System.getProperty("user.dir") + "\\ExcelFiles\\Test_Data.xlsx");
		XSSFSheet create_criti = x.Setsheet("Scenario_Login");
		int xlRowcount = x.getrowcount(create_criti);
		
		//Declare a Array List
		List<String[]> List_login= new ArrayList<String[]>();
		
		//traversing Excel
		for(int xlRow=1;xlRow<=xlRowcount;xlRow++)
		{
			
			String Execute_Flag = x.Readvalue(create_criti, xlRow, "Execute_Flag");
			String Scriptname = x.Readvalue(create_criti, xlRow, "Scriptname");
			
			
			if((Execute_Flag.equals("Y")&&(Scriptname.equals(script_name))))
				{
				
				String[] arr_login= new String[5];
				
				arr_login[0]=x.Readvalue(create_criti, xlRow, "TC_ID");
				arr_login[1]=x.Readvalue(create_criti, xlRow, "Order");
				arr_login[2]=x.Readvalue(create_criti, xlRow, "Uname");
				arr_login[3]=x.Readvalue(create_criti, xlRow, "Pwd");
				arr_login[4]=x.Readvalue(create_criti, xlRow, "Exp_Res");
				
				
				List_login.add(arr_login);			
				}//end of if
								
		}//end of for
		
		return List_login;
	}

}
