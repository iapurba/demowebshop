package test.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    @Override
    public boolean retry(ITestResult result) {
        int count = 0, retryCount = 1;
        while (count < retryCount) {
            count++;
        }
        return false;
    }
}
