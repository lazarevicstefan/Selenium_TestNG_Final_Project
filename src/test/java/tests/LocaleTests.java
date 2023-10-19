package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LocaleTests extends BasicTest{
    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToES(){
        String expectedHeaderText = "Página de aterrizaje";

        navPage.clickOnLanguageDropdownButton();
        navPage.clickOnESButtonFromLanguageDropdown();
        Assert.assertTrue(navPage.verifyIsNavPageIsOnLanguage(expectedHeaderText)
                ,"Actual header text doesn't match expected header text");
    }
    @Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
    public void setLocaleToEN(){
        String expectedHeaderText = "Landing";

        navPage.clickOnLanguageDropdownButton();
        navPage.clickOnENButtonFromLanguageDropdown();
        Assert.assertTrue(navPage.verifyIsNavPageIsOnLanguage(expectedHeaderText)
                ,"Actual header text doesn't match expected header text");
    }
}
