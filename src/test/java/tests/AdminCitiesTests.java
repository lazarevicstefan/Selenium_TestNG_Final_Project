package tests;

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
    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
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
        Assert.assertEquals(messagePopUpPage.getSuccessfullyMessageString(),expectedPopUpMessage, "");

    }
}
