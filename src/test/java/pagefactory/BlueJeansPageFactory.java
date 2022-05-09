package test.java.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlueJeansPageFactory {
	
	WebDriver driver;
	
	@FindBy(id="addtocart_36_EnteredQuantity")
	private WebElement quantityField;

	@FindBy(xpath="//div[@class='add-to-cart-panel']//input[@type='button']")
	private WebElement addToCartBtn;
	
//	Constructor
	public BlueJeansPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 
	public void enterQuantity(int qty) {
		quantityField.clear();
		quantityField.sendKeys(Integer.toString(qty));
	}

	public void clickAddToCart() {
		addToCartBtn.click();
	}

}
