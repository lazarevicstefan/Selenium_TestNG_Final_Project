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
    @Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes(){
        String expectedEmail = "email";
        String expectedPassword = "password";

        navPage.clickOnSignUpButton();
        String actualEmail = signupPage.getEmailElement().getAttribute("type");
        String actualPassword = signupPage.getPasswordElement().getAttribute("type");

        Assert.assertEquals(actualEmail, expectedEmail
                ,"Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(actualPassword, expectedPassword
                ,"Actual attribute value doesn't match expected attribute value");
    }

}
