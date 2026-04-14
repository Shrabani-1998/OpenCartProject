package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class)
	public void verify_loginDDT(String email, String pwd,String exp) {
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();

		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPwd(pwd);
		lp.clickLogin();

		MyAccountPage map = new MyAccountPage(driver);
		boolean targerRes=map.isMyAccountExist();
		
		if(exp.equalsIgnoreCase("valid")) {
			if(targerRes) {
				map.clickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(targerRes==true) {
				map.clickLogout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
}
