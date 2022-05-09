package test.java.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CheckoutPageFactory {

    WebDriver driver;

    @FindBy(xpath = "//div[@id='billing-buttons-container']//input[@title='Continue']")
    private WebElement billingAddressContinueBtn;

    @FindBy(xpath = "//div[@id='shipping-buttons-container']//input[@title='Continue']")
    private WebElement shippingAddressContinueBtn;


    @FindBy(xpath = "//input[@name='shippingoption']")
    private List<WebElement> shippingMethodOptions;

    @FindBy(xpath = "//div[@id='shipping-method-buttons-container']//input[@value='Continue']")
    private WebElement shippingMethodContinueBtn;

    @FindBy(xpath = "//input[@name='paymentmethod']")
    private List<WebElement> paymentMethodOptions;

    @FindBy(xpath = "//div[@id='payment-method-buttons-container']//input[@value='Continue']")
    private WebElement paymentMethodContinueBtn;

    //	Select locator
    @FindBy(id = "CreditCardType")
    private WebElement creditCardType;

    private Select getCreditCardTypeOptions() {
        Select creditCardSelect = new Select(creditCardType);
        return creditCardSelect;
    }

    @FindBy(id = "CardholderName")
    private WebElement cardholderNameTextBox;

    @FindBy(id = "CardNumber")
    private WebElement cardNumberInputBox;

    @FindBy(id = "ExpireMonth")
    private WebElement expireMonth;

    private Select getExpireMonthOptions() {
        return new Select(expireMonth);
    }

    @FindBy(id = "ExpireYear")
    private WebElement expireYear;

    private Select getExpireYearOptions() {
        return new Select(expireYear);
    }

    @FindBy(id = "CardCode")
    private WebElement cardCode;

    @FindBy(xpath = "//div[@id='payment-info-buttons-container']//input[@value='Continue']")
    private WebElement paymentInformationContinueBtn;

    @FindBy(xpath = "//div[@id='confirm-order-buttons-container']//input[@value='Confirm']")
    private WebElement confirmOrderBtn;

    //	Constructor
    public CheckoutPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickBillingAddressContinue() {
        billingAddressContinueBtn.click();
    }

    public void clickShippingAddressContinue() {
        shippingAddressContinueBtn.click();
    }

    //	Shipping Method options
//	Ground
    public void clickShippingMethodGround() {
        shippingMethodOptions.get(0).click();
    }

    //  Next Day Air
    public void clickShippingMethodNextDayAir() {
        shippingMethodOptions.get(1).click();
    }

    //	2nd Day Air
    public void clickShippingMethod2ndDayAir() {
        shippingMethodOptions.get(2).click();
    }

    public void clickShippingMethodContinue() {
        shippingMethodContinueBtn.click();
    }

    //	Payment Method Options
    public void clickPaymentMethodCOD() {
        paymentMethodOptions.get(0).click();
    }

    public void clickPaymentMethodCheckMoneyOrder() {
        paymentMethodOptions.get(1).click();
    }

    public void clickPaymentMethodCreditCard() {
        paymentMethodOptions.get(2).click();
    }

    public void clickPaymentMethodPurchaseOrder() {
        paymentMethodOptions.get(3).click();
    }

    //	Payment method continue
    public void clickPaymentMethodContinue() {
        paymentMethodContinueBtn.click();
    }

    //	Payment information credit card
    public void selectCreditCardVisa() {
        getCreditCardTypeOptions().selectByValue("Visa");
    }

    public void selectCreditCardMasterCard() {
        getCreditCardTypeOptions().selectByValue("MasterCard");
    }

    public void selectCreditCardDiscover() {
        getCreditCardTypeOptions().selectByValue("Discover");
    }

    public void selectCreditCardAmex() {
        getCreditCardTypeOptions().selectByValue("Amex");
    }

    public void enterCardholderName(String holderName) {
        cardholderNameTextBox.sendKeys(holderName);
    }

    public void enterCardNumber(String number) {
        cardNumberInputBox.sendKeys(number);
    }

    public void selectExpireMonth(int month) {
        getExpireMonthOptions().selectByValue(Integer.toString(month));
    }

    public void selectExpireYear(int year) {
        getExpireYearOptions().selectByValue(Integer.toString(year));
    }

    public void enterCardCode(int code) {
        cardCode.sendKeys(Integer.toString(code));
    }

    //	Payment information continue
    public void clickPaymentInformationContinue() {
        paymentInformationContinueBtn.click();
    }

    public void clickConfirmOrder() {
        confirmOrderBtn.click();
    }

}
