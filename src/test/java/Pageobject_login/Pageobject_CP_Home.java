package Pageobject_login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Pageobject_CP_Home {

	//1)Click on Home button
	 @FindBy(xpath="//*[@id='Home']/a/span")
	 WebElement CP_Home;
	 
	 //2)Click on Branch Button
	 @FindBy(xpath="//*[@id='Branch']/a/span[1]")
	 WebElement CP_Branch;
	 
	 //3)Click on Location Button
	 @FindBy(xpath="//*[@id='Location']/a/span[1]")
	 WebElement CP_Location;
	 
	 //4)Click on Employee Button
	 @FindBy(xpath="//*[@id='Employee']/a/span[1]")
	 WebElement CP_Employee;
	
	 //5)Click on Roles Button
	 @FindBy(xpath="//*[@id='Roles']/a/span[1]")
	 WebElement CP_Roles;
	 
	 //6)Click on Asset Button
	 @FindBy(xpath="//*[@id='Asset']/a/span[1]")
	 WebElement CP_Asset;
	
	 //7)Click on Supplier Button
	 @FindBy(xpath="//*[@id='Supplier']/a/span[1]")
	 WebElement CP_Supplier;
	 
	 //8)Click on Custom Attribute Button
	 @FindBy(xpath="//*[@id='CustomAttributes']/a/span[1]")
	 WebElement CP_Custom;
	 
	 //9)Click on Profiles Button
	 @FindBy(xpath="//*[@id='Profiles']/a/span[1]")
	 WebElement CP_Profiles;
	 
	 //10)Click on Masters Button
	 @FindBy(xpath="//*[@id='Masters']/a/span[1]")
	 WebElement CP_Masters;
	 
	 //11)Click On Maintenance Masters
	 @FindBy(xpath="//*[@id='MaintenanceMasters']/a/span[1]")
	 WebElement CP_MM;
	 
	 
	 
	
}
