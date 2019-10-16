package com.test.qa.pageobjects.pages;

import com.test.qa.pageobjects.utils.PageBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class AddKPI extends PageBase {
    private static final Logger LOGGER = Logger.getLogger(AddKPI.class);

    private static By hdrAddKPIPage = By.xpath("//h1");
    private static By addButton = By.id("btnAdd");
    private static By job_Title_Dropdown = By.id("defineKpi360_jobTitleCode");
    private static By keyPerformanceIndicator = By.id("defineKpi360_keyPerformanceIndicators");
    private static By miniumRating = By.id("defineKpi360_minRating");
    private static By maxRating = By.id("defineKpi360_maxRating");
    private static By makeDefault = By.id("defineKpi360_makeDefault");
    private static By saveButton = By.id("saveBtn");

    public static boolean isAddKPIPAgeDipslayed() {
        return getDriver().findElement(hdrAddKPIPage).isDisplayed();
    }
    public static boolean isAddButtonDisplayed() {
        return getDriver().findElement(addButton).isDisplayed();
    }

    public static boolean isDropdownDisplayed() {
        return getDriver().findElement(job_Title_Dropdown).isDisplayed();
    }

    public static boolean isKeyPerformanceDisplayed() {
        return getDriver().findElement(keyPerformanceIndicator).isDisplayed();
    }

    public static boolean isminRatingDisplayed() {
        return getDriver().findElement(miniumRating).isDisplayed();
    }

    public static boolean isMaxRatingDisplayed() {
        return getDriver().findElement(maxRating).isDisplayed();
    }

    public static boolean isMakeDefaulktCheckBoxDisplayed() {
        return getDriver().findElement(makeDefault).isDisplayed();
    }
    public static boolean isSaveButtonDisplayed(){
        return getDriver().findElement(saveButton).isDisplayed();
    }

    public static void clickAddButton(){
        getDriver().findElement(addButton).click();
    }
    public static void setJobTitle(String jobTitle){
        Select drpdown = new Select(getDriver().findElement(job_Title_Dropdown));
        drpdown.selectByVisibleText(jobTitle);
    }


    public static void setKeyPerformanceIndicator(String key){
        getDriver().findElement(keyPerformanceIndicator).clear();
        getDriver().findElement(keyPerformanceIndicator).sendKeys(key);
    }
    public static void setMiniumRating(String min){
        getDriver().findElement(miniumRating).clear();
        getDriver().findElement(miniumRating).sendKeys(min);
    }
    public static void setMaxRating(String max){
        getDriver().findElement(maxRating).clear();
        getDriver().findElement(maxRating).sendKeys(max);
    }
    public static void clickMakeDefault(){
        getDriver().findElement(makeDefault).click();
    }
    public static void clickSaveButton(){
        getDriver().findElement(saveButton).click();
    }
    public static void  addKPIs(String jobTitle,String KPI,String minRating,String maxRating){
        AddKPI.setJobTitle(jobTitle);
        AddKPI.setKeyPerformanceIndicator(KPI);
        AddKPI.setMiniumRating(minRating);
        AddKPI.setMaxRating(maxRating);
        AddKPI.clickMakeDefault();
        AddKPI.clickSaveButton();
    }
}
