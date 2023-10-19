package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class SignupTests extends BasicTest{
    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void visitsTheSignupPage () {
        navPage.clickOnSignUpButton();
        Assert.assertTrue(signupPage.verifyIsSignupPage()
                , "Actual URL doesn't match expected URL");
    }
}
