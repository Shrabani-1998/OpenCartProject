package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test
	public void verify_Account_Registration() {
		HomePage hp=new HomePage(driver);
		try {
		hp.clickMyAccount();
		hp.clickRegister();
		
		AccountRegistrationPage regPage=new AccountRegistrationPage(driver);
		
		regPage.setFirstname(getString().toUpperCase());
		regPage.setLirstname(getString().toUpperCase());
		regPage.setEmail(getString().toLowerCase()+"@gmail.com");
		regPage.setTelephone(getNumber());
		regPage.setPassword("8724125gT");
		regPage.setConfirmPwd("8724125gT");
		regPage.setPrivacyPolicy();
		regPage.setContinue();
		
		String getMsg=regPage.successMsg();
		System.out.println(getMsg);
		Assert.assertEquals(getMsg, "Your Account Has Been Created!");
		}
		catch(Exception e) {
			e.getMessage();
		}
		
	
	}
	
}
