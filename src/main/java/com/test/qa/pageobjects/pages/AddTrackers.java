package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;


public class AddTrackers extends PageBase {
    private static final Logger LOGGER = Logger.getLogger(AddTrackers.class);

    private static By addTrackersPage = By.xpath("(//h1)[2]");
    private static By addButton = By.id("btnAdd");
    private static By trackerName = By.id("addPerformanceTracker_tracker_name");
    private static By employeeName = By.id("addPerformanceTracker_employeeName_empName");
    private static By allocationEmployeeTable = By.id("addPerformanceTracker_availableEmp");
    private static String commonOption = "//option[@value = 'THANU']";
    private static By assignAddButton = By.id("btnAssignEmployee");
    private static By saveButton = By.id("btnSave");

    public static boolean isAddTrackerPageDisplayed(){
        return getDriver().findElement(addTrackersPage).isDisplayed();
    }
    public static boolean isAddButtonDisplayed(){
        return getDriver().findElement(addButton).isDisplayed();
    }
    public static boolean isTrackerNameDisplayed(){
        return getDriver().findElement(trackerName).isDisplayed();
    }
    public static boolean isEmployeeNameDisplayed(){
        return getDriver().findElement(employeeName).isDisplayed();
    }
    public static boolean isAllocationEmployyTableDisplayed(){
        return getDriver().findElement(allocationEmployeeTable).isDisplayed();
    }
    public static boolean isAssignAddButtonDisplayed(){
        return getDriver().findElement(assignAddButton).isDisplayed();
    }
    public static boolean isSaveButtonDisplayed(){
        return getDriver().findElement(saveButton).isDisplayed();
    }
    public static void clickAddButton(){
        getDriver().findElement(addButton).click();
    }
    public static void setTrackerName(String tName){
        getDriver().findElement(trackerName).sendKeys(tName);
    }
    public static void setEmployeeName(String eName){
        getDriver().findElement(employeeName).sendKeys(eName);
    }
    public static void clickAssign(String option){
        getDriver().findElement(By.xpath(commonOption.replace("THANU", option))).click();
    }
    public static void clickAssignAddButton(){
        getDriver().findElement(assignAddButton).click();
    }
    public static void clickSaveButton(){
        getDriver().findElement(saveButton).click();
    }

}
