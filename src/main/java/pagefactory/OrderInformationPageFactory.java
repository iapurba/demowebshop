package main.java.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderInformationPageFactory {
	WebDriver driver;
	
	@FindBy(xpath="//input[@value='Re-order']")
	private WebElement reorderBtn;
	
	public OrderInformationPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickReorderNButton() {
		reorderBtn.click();
	}
}
