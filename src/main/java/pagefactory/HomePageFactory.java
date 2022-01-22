package main.java.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory {
	
	WebDriver driver;
	
	@FindBy(xpath="//a[@href='/login']")
	private WebElement loginMenu;
//	
	@FindBy(xpath="//a[@href='/logout']")
	private WebElement logoutMenu;
	
	@FindBy(xpath="//li[@id='topcartlink']//a[@href='/cart']")
	private WebElement shoppingCartMenu;
	
	@FindBy(xpath="//ul[@class='top-menu']//a[@href='/apparel-shoes']")
	private WebElement apparelAndShoesTab;
	
	@FindBy(xpath="//div[@class='header-links']//a[@href='/customer/info']")
	private WebElement myAccountMenu;
	
//	Constructor
	public HomePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void navigateToLoginPage() {
		loginMenu.click();
	}
	
	public void navigateToShoppingCart() {
		shoppingCartMenu.click();
	}
	
	public void logoutWebshop() {
		logoutMenu.click();
	}
	
	public void navigateToMyAccount() {
		myAccountMenu.click();
	}
	
	public void clickApparelAndShoesTab() {
		apparelAndShoesTab.click();
	}

}
