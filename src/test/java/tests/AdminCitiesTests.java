package tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AdminCitiesTests extends BasicTest{
    @Test (priority = 1, retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheAdminCitiesPageAndListCities (){
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";

        navPage.clickOnLoginButton();

        loginPage.clearAndEnterEmail(adminEmail);
        loginPage.clearAndEnterPassword(adminPassword);
        loginPage.clickOnLoginButton();

        navPage.clickOnAdminDropdownButton();
        navPage.clickOnCitiesButtonFromAdminDropdown();

        Assert.assertTrue(citiesPage.verifyIsAdminCitiesPage()
                , "Actual URL doesn't match expected URL");
    }
    @Test(priority = 2)
    public void checksInputTypesForCreateEditNewCity () {
        String expectedFieldText = "text";

        navPage.clickOnAdminDropdownButton();
        navPage.clickOnCitiesButtonFromAdminDropdown();

        citiesPage.clickOnNewItemButton();
        citiesPage.waitForNewItemAndDeleteDialogToBeShow();

        String actualFieldText = citiesPage.getEnterNameInNewItemElement().getAttribute("type");
        Assert.assertEquals(actualFieldText,expectedFieldText
                ,"Actual attribute value doesn't match expected attribute value");
    }
    @Test(priority = 3)
    public void createNewCity(){
        String city = "Stefan Lazarevic's city";
        String expectedPopUpMessage = "Saved successfully\nCLOSE";

        navPage.clickOnAdminDropdownButton();
        navPage.clickOnCitiesButtonFromAdminDropdown();

        citiesPage.clickOnNewItemButton();
        citiesPage.waitForNewItemAndDeleteDialogToBeShow();

        citiesPage.clearAndEnterNameInNewItem(city);
        citiesPage.clickOnSaveButtonInEditAndCreateDialog();

        messagePopUpPage.waitForPopUpSuccessfullyMessageToShow();
        Assert.assertEquals(messagePopUpPage.getSuccessfullyMessageString(),expectedPopUpMessage
                , "Actual pop up message doesn't match expected pop up message");
    }
    @Test(priority = 4,retryAnalyzer = RetryAnalyzer.class)
    public void editCity (){
        String oldCityName = "Stefan Lazarevic's city";
        String newCityName = "Stefan Lazarevic's city Edited";
        String expectedPopUpMessage = "Saved successfully\nCLOSE";

        navPage.clickOnAdminDropdownButton();
        navPage.clickOnCitiesButtonFromAdminDropdown();

        citiesPage.searchWithName(oldCityName);
        citiesPage.waitForTableToShowInputtedRows(1);
        citiesPage.clickOnEditButtonFromRow(1);
        citiesPage.waitForNewItemAndDeleteDialogToBeShow();

        citiesPage.getEnterNameInNewItemElement().sendKeys(Keys.CONTROL,"a", Keys.DELETE);
        citiesPage.clearAndEnterNameInNewItem(newCityName);
        citiesPage.clickOnSaveButtonInEditAndCreateDialog();

        messagePopUpPage.waitForPopUpSuccessfullyMessageToShow();
        Assert.assertEquals(messagePopUpPage.getSuccessfullyMessageString(),expectedPopUpMessage
                , "Actual pop up message doesn't match expected pop up message");
    }
    @Test(priority = 5, retryAnalyzer = RetryAnalyzer.class)
    public void searchCity(){
        String cityName = "Stefan Lazarevic's city Edited";

        navPage.clickOnAdminDropdownButton();
        navPage.clickOnCitiesButtonFromAdminDropdown();

        citiesPage.searchWithName(cityName);
        citiesPage.waitForTableToShowInputtedRows(1);

        Assert.assertEquals(citiesPage
                        .getCellFromInputtedRowAndColumnString(1,2),cityName
                        ,"Actual city name doesn't match expected name");
    }
    @Test(priority = 6)
    public void deleteCity(){
        String cityName = "Stefan Lazarevic's city Edited";
        String expectedPopUpMessage = "Deleted successfully\nCLOSE";

        navPage.clickOnAdminDropdownButton();
        navPage.clickOnCitiesButtonFromAdminDropdown();

        citiesPage.searchWithName(cityName);
        citiesPage.waitForTableToShowInputtedRows(1);

        Assert.assertEquals(citiesPage
                        .getCellFromInputtedRowAndColumnString(1,2),cityName
                ,"Actual city name doesn't match expected name");

        citiesPage.clickOnDeleteButtonFromRow(1);
        citiesPage.waitForNewItemAndDeleteDialogToBeShow();
        citiesPage.clickOnDeleteButtonInDeleteDialog();

        messagePopUpPage.waitForPopUpSuccessfullyMessageToShow();
        Assert.assertEquals(messagePopUpPage.getSuccessfullyMessageString(),expectedPopUpMessage
                , "Actual pop up message doesn't match expected pop up message");
    }

}
