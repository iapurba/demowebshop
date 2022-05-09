package test.java.testclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.pagefactory.*;

import java.time.Duration;

public class LoginWebShop {
    WebDriver driver;
    String baseURL = "http://demowebshop.tricentis.com/";

    HomePageFactory homePage;
    LoginPageFactory loginPage;

    @BeforeMethod
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get(baseURL);

        homePage = new HomePageFactory(driver);
        loginPage = new LoginPageFactory(driver);
    }

    @Test
    public void testLogin() {
        homePage.navigateToLoginPage();

        String email = "apurba.panja@tcs.test";
        String password = "Tosca1234!";

        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickRememberMeCheckbox();
        loginPage.clickLoginButton();
    }
}
