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
        String adminEmail = "admin@admin.com";
        String adminPassword = "12345";
        String expectedFieldText = "text";

        navPage.clickOnLoginButton();

        loginPage.clearAndEnterEmail(adminEmail);
        loginPage.clearAndEnterPassword(adminPassword);
        loginPage.clickOnLoginButton();

        navPage.clickOnAdminDropdownButton();
        navPage.clickOnCitiesButtonFromAdminDropdown();

        citiesPage.clickOnNewItemButton();
        citiesPage.waitForDeleteDialogToBeShow();

        String actualFieldText = citiesPage.getEnterNameInNewItemElement().getAttribute("type");
        Assert.assertEquals(actualFieldText,expectedFieldText
                ,"Actual attribute value doesn't match expected attribute value");

    }
}
