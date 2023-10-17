package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class LoginTests extends BasicTest {
    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheLoginPage () {
        navPage.clickOnLanguageDropdownButton();
        navPage.clickOnENButtonFromLanguageDropdown();
        navPage.clickOnLoginButton();
        Assert.assertTrue(loginPage.verifyIsLoginPage()
                , "Actual URL doesn't match expected URL");
    }
}
