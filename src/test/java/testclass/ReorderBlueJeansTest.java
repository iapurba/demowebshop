package test.java.testclass;

import org.testng.annotations.Test;

import test.java.pagefactory.*;

public class ReorderBlueJeansTest extends BaseTest{

    HomePageFactory homePage;
    LoginPageFactory loginPage;
    MyAccountPageFactory myAccountPage;
    MyOrderPageFactory myOrderPage;
    OrderInformationPageFactory orderInformationPage;

    @Test(priority = 1)
    public void loginWebShop() {

        homePage.navigateToLoginPage();

        String email = "apurba.panja@tcs.test";
        String password = "Tosca1234!";

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickRememberMeCheckbox();
        loginPage.clickLoginButton();
    }

    @Test(priority = 2)
    public void navigateToMyAccount() {
        homePage.navigateToMyAccount();
    }

    @Test(priority = 3)
    public void navigateToOrderHistory() {
        myAccountPage.navigateToOrderHistoryPage();
    }

    @Test(priority = 4)
    public void navigateOrderDetailPage() {
        myOrderPage.clickDetailBtn(1);
    }

    @Test(priority = 5)
    public void reorderItem() {
        orderInformationPage.clickReorderNButton();
    }
}

