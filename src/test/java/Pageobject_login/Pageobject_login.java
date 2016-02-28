package Pageobject_login;


import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Pageobject_login {

	public WebDriver browser;
	
	//*************************************************
///////////////for login///////////////////////
    @FindBy(xpath="//*[@id='username']")
    WebElement UNtext;

    @FindBy(xpath="//*[@id='password']")
    WebElement Pass;
	
	@FindBy(id="btnLogin")
	private WebElement LoginButton;
	
	@FindBy(xpath="//*[@id='content']/div/div/form/div/ul/li")
	WebElement Invalidmsg;
	
	@FindBy(className="hello")
	WebElement validmsg;
	
	
	//with different category name edit succesfull 
	//@FindBy(xpath="//*[@id='CategoryTableContainer']/div/table/tbody/tr/td[2]")
	//WebElement msg_Valid_result;
	//html body div#wrap div#header.topborder.relative div.floatR.extra_gap div.floatL div span#username.bold a.proper
	
	//***************************************
	
	//Action on those Elements through different methods
	
	//constructor to initialize browser
	
	public Pageobject_login(WebDriver Dbrowser)
	{
		this.browser=Dbrowser;
		PageFactory.initElements(browser, this);
				
	}
	
	//methods for different actions
	/// method to click CP
	public void Enter_Username(String username)
	{
		UNtext.sendKeys(username);
	}
	
	//public void wait_Enter_password(WebDriver browser){
	//Explicit wait for the driver
	//WebDriverWait wait = new WebDriverWait(browser,60);
	//wait.until(ExpectedConditions.visibilityOf(Pass));
	//}
	
	
	
	public void Enter_password(String password)
	{
		Pass.sendKeys(password);
	}
	
	public void Click_login()
	{
		LoginButton.click();
	}
	
	
	public String Invalid_Login_message()
	{
		return Invalidmsg.getText();
	}

	public String Valid_login()
	{
		return validmsg.getText();
		
	}
	
	//**********************************************************************************
	
	//Common process component
	
	public void Commonprocesslogin(String Uname,String Pwd)
	{
		UNtext.clear();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        UNtext.sendKeys(Uname);
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Pass.clear();
        browser.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);  
        Pass.sendKeys(Pwd);
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Click_login();
        
	}
}
