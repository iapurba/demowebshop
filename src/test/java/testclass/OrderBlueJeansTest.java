package test.java.testclass;

import main.java.pagefactory.*;
import main.java.utils.ExcelUtils;
import org.testng.annotations.*;

import java.io.File;

public class OrderBlueJeansTest extends BaseTest {

    HomePageFactory homePage;
    LoginPageFactory loginPage;
    ApparelAndShoesPageFactory apparelAndShoesPage;
    BlueJeansPageFactory blueJeansPage;
    ShoppingCartPageFactory shoppingCartPage;
    CheckoutPageFactory checkoutPage;
    OrderSuccessPageFactory orderSuccessPage;

    @BeforeClass
    public void beforeClass() {
        homePage = new HomePageFactory(driver);
        loginPage = new LoginPageFactory(driver);
        apparelAndShoesPage = new ApparelAndShoesPageFactory(driver);
        blueJeansPage = new BlueJeansPageFactory(driver);
        shoppingCartPage = new ShoppingCartPageFactory(driver);
        checkoutPage = new CheckoutPageFactory(driver);
        orderSuccessPage = new OrderSuccessPageFactory(driver);
    }

    @Test(priority = 1)
    @Parameters({"email", "password"})
    public void loginWebShop(String email, String password) throws Exception {
        homePage.navigateToLoginPage();

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickRememberMeCheckbox();
        loginPage.clickLoginButton();

        String filepath = System.getProperty("user.dir") + File.separator + "testdata" + File.separator + "UserData.xlsx";
        Object[][] data = ExcelUtils.getExcelData(filepath, "Sheet1");
    }

    @Test(priority = 2)
    public void navigateToApparelAndShoes() {
        homePage.clickApparelAndShoesTab();
    }

    @Test(priority = 3)
    public void navigateToBlueJean() {
        apparelAndShoesPage.clickBlueJeans();
    }

    @Test(priority = 4)
    public void addBlueJeansToShoppingCart() throws Exception {
        blueJeansPage.enterQuantity(5);
        blueJeansPage.clickAddToCart();
        Thread.sleep(2000);
    }

    @Test(priority = 5)
    public void navigateToShoppingCart() {
        homePage.navigateToShoppingCart();
    }

    @Test(priority = 6)
    public void navigateToCheckout() {
        shoppingCartPage.clickAcceptTermsOfService();
        shoppingCartPage.clickCheckoutButton();
    }

    @Test(priority = 7)
    public void startCheckout() {
        checkoutPage.clickBillingAddressContinue();

        checkoutPage.clickShippingAddressContinue();

        checkoutPage.clickShippingMethodGround();
        checkoutPage.clickShippingMethodContinue();

        checkoutPage.clickPaymentMethodCreditCard();
        checkoutPage.clickPaymentMethodContinue();
    }

    @Test(priority = 8)
    public void enterCreditCardInformation() {
//      Enter Credit Card Information
        checkoutPage.selectCreditCardVisa();
        checkoutPage.enterCardholderName("Random Name");
        checkoutPage.enterCardNumber("4485564059489345");
        checkoutPage.selectExpireMonth(3);
        checkoutPage.selectExpireYear(2022);
        checkoutPage.enterCardCode(123);
        checkoutPage.clickPaymentInformationContinue();

        checkoutPage.clickConfirmOrder();
    }

    @Test(priority = 9)
    public void orderSuccessContinue() {
        orderSuccessPage.clickOrderSuccessContinue();
    }

    @Test(priority = 10)
    public void logoutWebShop() {
        homePage.logoutWebshop();
    }


}
