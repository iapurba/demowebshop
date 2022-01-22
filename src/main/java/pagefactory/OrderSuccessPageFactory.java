package main.java.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSuccessPageFactory {
	WebDriver driver;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement orderSuccessContinueBtn;
	
//	Constructor
	public OrderSuccessPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrderSuccessContinue() {
		orderSuccessContinueBtn.click();
	}
}
