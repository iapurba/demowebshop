package main.java.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparelAndShoesPageFactory {
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='details']//a[@href='/blue-jeans']")
	private WebElement blueJeans;
	
	@FindBy(xpath="//div[@data-productid='36']//input[@value='Add to cart']")
	private WebElement blueJeansAddToCart;
	
//	Constructor
	public ApparelAndShoesPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickBlueJeans() {
		blueJeans.click();
	}
	 
	public void clickAddToCartBlueJeans() {
		blueJeansAddToCart.click();
	}
	
}
