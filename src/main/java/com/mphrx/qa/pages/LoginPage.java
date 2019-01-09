package com.mphrx.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mphrx.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="lgnC_m_UncV")
	WebElement username;
	
    @FindBy(id="lgnC_m_PcV")
    WebElement password;
    
    @FindBy(xpath="//input[@id='lgnC_m_loginBtn']")
    WebElement loginBtn;
    
    @FindBy(id="lgnC_rSignUpBtn")
    WebElement SignUpBtn;
    
    @FindBy(id="lgnC_h_brand")
    WebElement Logo;
    
    public LoginPage()
    {
    	PageFactory.initElements(driver, this);
    }
    
    public String validateLoginPageTitle() {
    	return driver.getTitle();
    	
    }
    
    public boolean validateLogo()
    {
    	 return Logo.isDisplayed();
    }
    
    public HomePage login(String un, String pwd)
    {
    	username.sendKeys(un);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	return new HomePage ();
    
    }
        
    

}
