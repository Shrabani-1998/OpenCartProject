package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends basePage {
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement login_email;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement login_pwd;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement login_btn;
	
	public void setEmail(String email) {
		login_email.sendKeys(email);
	}
	
	public void setPwd(String password) {
		login_pwd.sendKeys(password);
	}
	
	public void clickLogin() {
		login_btn.click();
	}
}
