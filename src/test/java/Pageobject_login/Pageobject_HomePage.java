package Pageobject_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageobject_HomePage {


		
		public WebDriver browser;
		
		//Asset Management
		@FindBy(xpath="html/body/div[1]/div/div/a[1]/div/div/span[2]")
		 WebElement EAM;
		
		//Control Panel
		@FindBy(xpath="html/body/div[1]/div/div/a[2]/div/div/span[2]")
        WebElement CP;
		
		//IT Assets
		@FindBy(xpath="html/body/div[1]/div/div/a[3]/div/div/span[2]")
        WebElement IT;
		
		//Maintenance
        @FindBy(xpath="html/body/div[1]/div/div/a[4]/div/div/span[2]")
        WebElement MT;
        
        //Services
        @FindBy(xpath="html/body/div[1]/div/div/a[5]/div/div/span[2]")
        WebElement SER;
        
        
        public Pageobject_HomePage(WebDriver browser)
    	{
    		PageFactory.initElements(browser, this);
    	}
    	
		
        public void Click_AssetManagement()
    	{
        	EAM.click();
    	}
		
        public void Click_ControlPanel()
    	{
        	CP.click();
    	}
		
        public void Click_ITAssets()
    	{
        	IT.click();
    	}
		 
        public void Click_Maintenance()
    	{
        	MT.click();
    	}
		
        
        public void Click_Services()
    	{
        	SER.click();
    	}
		
		
        public void Commonprocess_HomePage()
        {
        	Click_AssetManagement();
        	Click_ControlPanel();
        	Click_ITAssets();
        	Click_Maintenance();
        	Click_Services();
        }
        
        
	}


