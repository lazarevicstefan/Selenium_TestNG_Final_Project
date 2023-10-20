package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class ProfileTests extends BasicTest{
    @Test(priority = 1)
    public void visitsTheProfilePage() {
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();

        loginPage.clearAndEnterEmail(email);
        loginPage.clearAndEnterPassword(password);
        loginPage.clickOnLoginButton();

        navPage.clickOnMyProfilePageButton();
        Assert.assertTrue(profilePage.verifyIsProfilePage()
                ,"Current URL should be " + baseUrl + "profile");

        Assert.assertEquals(profilePage.getProfileEmailString(),email
                ,"Actual email address doesn't match expected email address");

        navPage.clickOnLogOutButton();
    }
}
