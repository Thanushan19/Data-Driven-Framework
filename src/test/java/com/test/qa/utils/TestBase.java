package com.test.qa.utils;

import com.relevantcodes.extentreports.LogStatus;
import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

import static com.test.qa.pageobjects.utils.PageBase.extentReport;
import static com.test.qa.pageobjects.utils.PageBase.extentTest;

public class TestBase {
    public SoftAssert softAssert;

    private static final Logger LOGGER = Logger.getLogger(TestBase.class);

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        System.out.println("Test Running " + this.getClass().toString());
    }

    @BeforeMethod(alwaysRun = true)
    public void loadBrowser() {
        LOGGER.info("Initiate Browser");
        try {
            PageBase.initiateDriver();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        LOGGER.info("Browser Initiated");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
        softAssert = new SoftAssert();
    }

    @BeforeMethod(alwaysRun = true)
    public void nameBefore(Method method) {
        LOGGER.info("Test name: " + method.getName());
    }


    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method method, ITestResult result) {
        LOGGER.info("Executed test case name:" + method.getName() + " Execution Results : " + result.toString());
    }
    @AfterMethod(alwaysRun=true)
    public void endTest(ITestResult result) throws Exception {
        if(!result.isSuccess()){
            extentReport.endTest(extentTest);
            if (result.getStatus() == ITestResult.FAILURE) {
                extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(ExtentReportFunctions.getFilePath()));
                extentTest.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", result.getThrowable().getMessage());
            }
            else if (result.getStatus() == ITestResult.SKIP) {
                extentTest.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
            } else {
                extentTest.log(LogStatus.PASS, "Test passed");
            }

        }
        LOGGER.info("Closing Browser");
        PageBase.closeDriver();
        LOGGER.info("Browser Closed");
   }
    @AfterTest
    public void cleanUp(){
        extentReport.flush();
    }

}