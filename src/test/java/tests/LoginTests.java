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
    @Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        String expectedEmail = "email";
        String expectedPassword = "password";

        navPage.clickOnLoginButton();
        String actualEmail = loginPage.getEmailElement().getAttribute("type");
        String actualPassword = loginPage.getPasswordElement().getAttribute("type");

        Assert.assertEquals(actualEmail, expectedEmail
                ,"Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(actualPassword, expectedPassword
                ,"Actual attribute value doesn't match expected attribute value");
    }
}
