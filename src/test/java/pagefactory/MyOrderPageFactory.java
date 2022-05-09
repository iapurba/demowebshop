package test.java.pagefactory;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyOrderPageFactory {
	WebDriver driver;
	
	@FindBy(xpath ="//input[@value='Details']")
	private List<WebElement> prevOrderDetailsBtn;
	
	public MyOrderPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickDetailBtn(int itemNo) {
		prevOrderDetailsBtn.get(itemNo-1).click();
	}
	
}
