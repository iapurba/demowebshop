package test.java.testclass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class BaseTest {
    public static WebDriver driver;
    String baseURL = "http://demowebshop.tricentis.com";

    ExtentHtmlReporter htmlReporter;
    static ExtentReports extentReports;
    static ExtentTest logger;

    private void setupWebDriver(String browserName) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
    }

    @BeforeTest
    @Parameters({"browserName"})
    public void beforeTest(String browserName) {
//      Configuring Web Driver
        setupWebDriver(browserName);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(baseURL);

//      Configuring Extent Report file
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String filepath = System.getProperty("user.dir") + File.separator + "reports"
                + File.separator + "demowebshop-test-report" + timestamp + ".html";
        htmlReporter = new ExtentHtmlReporter(filepath);
        htmlReporter.config().setEncoding("UTF-8");
        htmlReporter.config().setDocumentTitle("Demowebshop Automation Report");
        htmlReporter.config().setReportName("Tricentis Demowebshop Automation Test Results");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
        extentReports.setSystemInfo("Automation Specialist", "Apurba Panja");

    }

    @BeforeMethod
    public void BeforeMethod(Method testMethod) {
        logger = extentReports.createTest(testMethod.getName());
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        String methodName = result.getMethod().getMethodName();

        if (result.getStatus() == ITestResult.SUCCESS) {
            String logInfo = String.format("Testcase: %s passed", methodName);
            Markup markup = MarkupHelper.createLabel(logInfo, ExtentColor.GREEN);
            logger.log(Status.PASS, markup);
        } else if (result.getStatus() == ITestResult.FAILURE) {
            String logInfo = String.format("Testcase: %s failed", methodName);
            Markup markup = MarkupHelper.createLabel(logInfo, ExtentColor.RED);
            logger.log(Status.FAIL, markup);
        } else if (result.getStatus() == ITestResult.SKIP) {
            String logInfo = String.format("Testcase: %s skipped", methodName);
            Markup markup = MarkupHelper.createLabel(logInfo, ExtentColor.YELLOW);
            logger.log(Status.SKIP, markup);
        }
    }

    @AfterTest
    public void afterTest() throws Exception {
        extentReports.flush();
        Thread.sleep(3000);
        driver.quit();
    }

}
