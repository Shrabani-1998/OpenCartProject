package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test
	public void verifyLogin() {
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPwd(p.getProperty("pwd"));
		lp.clickLogin();
		
		MyAccountPage map=new MyAccountPage(driver);
		Assert.assertEquals(map.isMyAccountExist(), true,"login failed");
		}
		catch(Exception e) {
			Assert.fail();
		}
	}

}
