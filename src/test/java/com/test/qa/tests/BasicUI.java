package com.test.qa.tests;

import com.relevantcodes.extentreports.LogStatus;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import com.sun.org.apache.bcel.internal.generic.DCONST;
import com.sun.xml.bind.v2.runtime.reflect.opt.Const;
import com.test.qa.pageobjects.pages.AddKPI;
import com.test.qa.pageobjects.pages.AddTrackers;
import com.test.qa.pageobjects.pages.DashBoardPage;
import com.test.qa.pageobjects.pages.LoginPage;
import com.test.qa.pageobjects.utils.Constants;
import com.test.qa.testdata.AddKPIData;
import com.test.qa.testdata.AddTrackerData;
import com.test.qa.testdata.UserLogin;
import com.test.qa.utils.MyScreenRecorder;
import com.test.qa.utils.TestBase;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import javax.activation.DataHandler;

import static com.test.qa.pageobjects.utils.PageBase.extentReport;
import static com.test.qa.pageobjects.utils.PageBase.extentTest;
public class BasicUI extends TestBase {
    private static final Logger LOGGER = Logger.getLogger(BasicUI.class);

    @Test(priority = 1, dataProvider = "OrangeHRMUserLogin", dataProviderClass = UserLogin.class)
    public void testVerifyLogin(String username, String password, String status, String alertmsg ) throws Exception {
        MyScreenRecorder.startRecording("Login Functionality");
        softAssert.assertTrue(LoginPage.isLoginPageDisplayed(), "LoginPage is not Displayed");
        LoginPage.setUsername(username);
        LoginPage.setPassword(password);
        LoginPage.clickLogin();
        if (status.equals("valid")) {

            softAssert.assertTrue(DashBoardPage.isDashBoardDisplayed());
            LOGGER.info("Login success");
        } else {
            LoginPage.isLoginAlertDisplay();
            softAssert.assertEquals(LoginPage.isLoginAlertDisplay(), alertmsg);
            LOGGER.info(alertmsg);
        }
        softAssert.assertTrue(DashBoardPage.isDashBoardDisplayed(), "Dashboard page is not Displayed");
        MyScreenRecorder.stopRecording();
        softAssert.assertAll();
    }


    @Test(priority = 2, dataProviderClass = AddKPIData.class, dataProvider = "KPIAddExcel")
    public void testAddKPI(String jobTitle, String KPI, String minRating, String maxRating) throws Exception {
        softAssert = new SoftAssert();
        MyScreenRecorder.startRecording("Check the AddKPI functionality");
        extentTest = extentReport.startTest("Check the AddKPI Functionality");
        softAssert.assertTrue(LoginPage.isLoginPageDisplayed(), "LoginPage is not Displayed");
        extentTest.log(LogStatus.PASS, "Login Page is Displayed");
        LoginPage.setUsername(Constants.ORANGE_USER_NAME);
        LoginPage.setPassword(Constants.ORANGE_PASSWORD);
        LoginPage.clickLogin();
        extentTest.log(LogStatus.PASS, "Login Successfully");
        softAssert.assertTrue(DashBoardPage.isDashBoardDisplayed(), "Dashboard is not displayed");
        extentTest.log(LogStatus.PASS, "DashBoard is Displayed");
        DashBoardPage.clickLinks(Constants.ORANGE_PERFORMANCE);
        DashBoardPage.clickLinks(Constants.ORANGE_PERFORMANCE_CONFIGURE);
        DashBoardPage.clickLinks(Constants.ORANGE_PERFORMANCE_CONFIGURE_KPI);
        AddKPI.clickAddButton();
        softAssert.assertTrue(AddKPI.isAddKPIPAgeDipslayed(), "Add KPI Page is not Displayed");
        extentTest.log(LogStatus.PASS, "Add KPI Page is Displayed");
        AddKPI.addKPIs(jobTitle,KPI,minRating,maxRating);
        extentTest.log(LogStatus.PASS, "Data Saved Successfully");
        DashBoardPage.clickWelcomeAdmin();
        DashBoardPage.clickLogOut();
        MyScreenRecorder.stopRecording();
        softAssert.assertAll();
    }

    @Test(priority = 3, dataProviderClass = AddTrackerData.class, dataProvider = "AddTrackerExcel")
    public void testAddTracker(String tName, String eName, String assignOpt) throws Exception {
        softAssert = new SoftAssert();
        MyScreenRecorder.startRecording("Add Trackers Functionality");
        extentTest = extentReport.startTest("Check Add Trackers Functionality");
        softAssert.assertTrue(LoginPage.isLoginPageDisplayed(), "LoginPage is not Displayed");
        extentTest.log(LogStatus.PASS, "Login PAge is Displayed");
        LoginPage.setUsername(Constants.ORANGE_USER_NAME);
        LoginPage.setPassword(Constants.ORANGE_PASSWORD);
        LoginPage.clickLogin();
        extentTest.log(LogStatus.PASS, "Login Successfully");
        softAssert.assertTrue(DashBoardPage.isDashBoardDisplayed(), "Dashboard is not Displayed");
        extentTest.log(LogStatus.PASS, "DashBoard Page is Displayed");
        DashBoardPage.clickLinks(Constants.ORANGE_PERFORMANCE);
        DashBoardPage.clickLinks(Constants.ORANGE_PERFORMANCE_CONFIGURE);
        DashBoardPage.clickLinks(Constants.ORANGE_PERFORMANCE_CONFIGURE_Trackers);
        softAssert.assertTrue(AddTrackers.isAddTrackerPageDisplayed(), "Add Tracker Page is not Displayed");
        extentTest.log(LogStatus.PASS, "Add Tracker Page is Displayed");
        AddTrackers.clickAddButton();
        AddTrackers.setTrackerName(tName);
        AddTrackers.setEmployeeName(eName);
        AddTrackers.clickAssign(assignOpt);
        AddTrackers.clickAssignAddButton();
        AddTrackers.clickSaveButton();
        DashBoardPage.clickWelcomeAdmin();
        DashBoardPage.clickLogOut();
        extentTest.log(LogStatus.PASS, "Datas entered Successfully");
        MyScreenRecorder.stopRecording();
        softAssert.assertAll();
    }
}
