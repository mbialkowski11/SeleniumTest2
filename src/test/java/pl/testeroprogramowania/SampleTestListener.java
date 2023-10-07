package pl.testeroprogramowania;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class SampleTestListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am starting test");
    }
    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am taking screenshot");
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

}
