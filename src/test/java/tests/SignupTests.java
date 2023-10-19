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
    @Test(priority = 3,retryAnalyzer = RetryAnalyzer.class)
    public void displaysErrorsWhenUserAlreadyExists (){
        String fullName = "Another User";
        String email = "admin@admin.com";
        String password = "12345";
        String confirmPassword = "12345";
        String expectedErrorMessage = "E-mail already exists";

        navPage.clickOnSignUpButton();
        Assert.assertTrue(signupPage.verifyIsSignupPage()
                , "Actual URL doesn't match expected URL");

        signupPage.clearAndEnterName(fullName);
        signupPage.clearAndEnterEmail(email);
        signupPage.clearAndEnterPassword(password);
        signupPage.clearAndEnterPasswordConfirm(confirmPassword);
        signupPage.clickOnSignMeUpButton();

        messagePopUpPage.waitForPopUpDialogToVisible();
        Assert.assertEquals(messagePopUpPage.getPopUpMessageString(),expectedErrorMessage
                ,"Actual pop up message doesn't match expected pop up message");
    }
    @Test(priority = 4)
    public void signup () {
        String fullName = "Stefan Lazarevic";
        String email = "stefan.lazarevic@itbootcamp.rsaaaaaaqaaaaqqqaaaa";
        String password = "12345";
        String confirmPassword = "12345";
        String expectedImportantMessage = "IMPORTANT: Verify your account";

        navPage.clickOnSignUpButton();

        signupPage.clearAndEnterName(fullName);
        signupPage.clearAndEnterEmail(email);
        signupPage.clearAndEnterPassword(password);
        signupPage.clearAndEnterPasswordConfirm(confirmPassword);
        signupPage.clickOnSignMeUpButton();

        navPage.clickOnHomePageButton();

        Assert.assertEquals(messagePopUpPage.getTextFromVerifyYourAccount()
                ,expectedImportantMessage
                ,"Actual pop up message doesn't match expected pop up message");

        messagePopUpPage.clickOnCloseButtonFromVerifyYourAccount();

        navPage.clickOnLogOutButton();
    }
}
