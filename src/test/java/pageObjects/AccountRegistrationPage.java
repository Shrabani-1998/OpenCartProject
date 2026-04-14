package pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends basePage{
	
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@name='email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@name='telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@name='confirm']")
	WebElement txtConfirmPwd;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkboxPolicy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//div[@class='col-sm-9']/h1")
	WebElement confirmationMsg;

	
	public void setFirstname(String fName) {
		txtFirstName.sendKeys(fName);
	}
	
	public void setLirstname(String lName) {
		txtLastName.sendKeys(lName);
	}
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String telNo) {
		txtTelephone.sendKeys(telNo);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPwd(String pwd) {
		txtConfirmPwd.sendKeys(pwd);
	}
	public void setPrivacyPolicy() {
		chkboxPolicy.click();
	}
	
	public void setContinue() {
		btnContinue.click();
	}
   
	public String successMsg() {
		try {
			return confirmationMsg.getText();
		}
		catch(Exception e) {
			return e.getMessage();
		}
	}

		
	}


