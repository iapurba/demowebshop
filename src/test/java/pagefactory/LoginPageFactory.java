package test.java.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory {
	WebDriver driver;
	
	@FindBy(id="Email")
	private WebElement emailField;
	
	@FindBy(id="Password")
	private WebElement passwordField;
	
	@FindBy(id="RememberMe")
	private WebElement rememberMeCheckbox;
	
	@FindBy(xpath="//input[@value='Log in']")
	private WebElement loginBtn;
	
//	Constructor
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickRememberMeCheckbox() {
		rememberMeCheckbox.click();
	}

	public void clickLoginButton() {
		loginBtn.click();
	}
}
