package main.java.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import test.java.testclass.OrderBlueJeansTest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class SuiteListener implements ITestListener, IAnnotationTransformer {
    @Override
    public void onTestFailure(ITestResult result) {
        String destination = System.getProperty("user.dir") + File.separator +
                "screenshots" + File.separator + result.getMethod().getMethodName();
        File source = ((TakesScreenshot) OrderBlueJeansTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(destination + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
