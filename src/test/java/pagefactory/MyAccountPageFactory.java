package test.java.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageFactory {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='side-2']//a[@href='/customer/orders']")
	private WebElement customerOrderMenu;
	
	public MyAccountPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	} 
	
	public void navigateToOrderHistoryPage() {
		customerOrderMenu.click();
	}
}
