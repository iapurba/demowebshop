package test.java.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPageFactory {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@id='termsofservice']")
	private WebElement termsOfServiceCheckbox;
	
	@FindBy(id="checkout")
	private WebElement checkoutBtn;
	
//	Constructor 
	public ShoppingCartPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	 
	public void clickAcceptTermsOfService() {
		termsOfServiceCheckbox.click();
	}
	
	public void clickCheckoutButton() {
		checkoutBtn.click();
	}
}
