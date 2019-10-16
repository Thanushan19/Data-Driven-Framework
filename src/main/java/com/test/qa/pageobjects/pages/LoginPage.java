package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class LoginPage extends PageBase {
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

    private static By hdrHomePage = By.xpath("//img[@src = '/webres_5d6f937c9c7169.68307390/themes/default/images/login/logo.png']");
    private static By username = By.id("txtUsername");
    private static By password = By.id("txtPassword");
    private static By loginButton = By.id("btnLogin");
    private static By alert = By.id("spanMessage");


    public static boolean isLoginPageDisplayed(){
        return getDriver().findElement(hdrHomePage).isDisplayed();
    }
    public static void setUsername(String name){
        getDriver().findElement(username).sendKeys(name);
    }
    public static void setPassword(String pass){
        getDriver().findElement(password).sendKeys(pass);
    }
    public static void clickLogin(){
        getDriver().findElement(loginButton).click();
    }

    public static boolean isLoginAlertDisplay() {
        return getDriver().findElement(alert).isDisplayed();
    }

    public static String getLoginAlert() {
        return  getDriver().findElement(alert).getText();
    }

    public static void login1(String userName, String password,String status,String alertMSg) {
        if(status=="valid") {
            LoginPage.setUsername(userName);
            LoginPage.setPassword(password);
            LoginPage.clickLogin();
            LOGGER.info("DashBoardPage is displayed");
            DashBoardPage.clickWelcomeAdmin();
            LOGGER.info("logout success");
            DashBoardPage.clickLogOut();
        }
        else {
            LoginPage.setUsername(userName);
            LoginPage.setPassword(password);
            LoginPage.clickLogin();
            LOGGER.info(alertMSg);
        }

    }
}
