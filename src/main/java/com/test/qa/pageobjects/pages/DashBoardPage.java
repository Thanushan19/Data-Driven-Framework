package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;

public class DashBoardPage extends PageBase {
    private static final Logger LOGGER = Logger.getLogger(DashBoardPage.class);

    private static By hdrDashBoard = By.xpath("//div[@id = 'panel_wrapper_1']");
    private static By welcomeAdmin = By.id("welcome");
    private static By logout = By.xpath("//*[text() = 'Logout']");

    private static String commonLink = "//*[@id = 'THANU']";

    public static boolean isDashBoardDisplayed(){
        return getDriver().findElement(hdrDashBoard).isDisplayed();
    }
    public static boolean isWelcomeAdminDisplayed(){
        return getDriver().findElement(welcomeAdmin).isDisplayed();
    }
    public static void clickWelcomeAdmin(){
        getDriver().findElement(welcomeAdmin).click();
    }
    public static boolean isLogoutDisplayed(){
        return getDriver().findElement(logout).isDisplayed();
    }
    public static void clickLogOut(){
        implicitWait(3);
        getDriver().findElement(logout).click();
    }

    public static void clickLinks(String link){
        getDriver().findElement(By.xpath(commonLink.replace("THANU", link))).click();
        LOGGER.info("Link" + link + "Clicked");
    }
}
