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
    @Test (priority = 2, retryAnalyzer = RetryAnalyzer.class)
    public void checksInputTypes() {
        String expectedEmail = "email";
        String expectedEmailDisable = "disabled";
        String expectedName = "text";
        String expectedCity = "text";
        String expectedCountry = "text";
        String expectedUrlTwitter = "url";
        String expectedUrlGitHub = "url";
        String expectedPhone = "tel";
        String email = "admin@admin.com";
        String password = "12345";

        navPage.clickOnLoginButton();

        loginPage.clearAndEnterEmail(email);
        loginPage.clearAndEnterPassword(password);
        loginPage.clickOnLoginButton();

        navPage.clickOnMyProfilePageButton();

        Assert.assertTrue(profilePage.verifyIsProfilePage()
                , "Current URL should be " + baseUrl + "profile");

        Assert.assertEquals(profilePage.getProfileEmailElement().getAttribute("type"), expectedEmail
                , "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(profilePage.getValueForDisableEmail(), expectedEmailDisable
                , "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(profilePage.getProfileNameElement().getAttribute("type"), expectedName
                , "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(profilePage.getProfileCityElement().getAttribute("type"), expectedCity
                , "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(profilePage.getProfileCountryElement().getAttribute("type"), expectedCountry
                , "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(profilePage.getProfileTwitterElement().getAttribute("type"), expectedUrlTwitter
                , "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(profilePage.getProfileGitHubElement().getAttribute("type"), expectedUrlGitHub
                , "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(profilePage.getProfilePhoneElement().getAttribute("type"), expectedPhone
                , "Actual attribute value doesn't match expected attribute value");

        navPage.clickOnLogOutButton();
    }
    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void editsProfile () {
        String email = "admin@admin.com";
        String password = "12345";
        String fullName = "Stefan Lazarevic";
        String phone = "+381612345678";
        String city = "Bucaramanga";
        String country = "Spain";
        String twitter = "https://twitter.com/profile";
        String github = "https://github.com/lazarevicstefan";
        String expectedErrorMessage = "Profile saved successfuly\nCLOSE";

        navPage.clickOnLoginButton();

        loginPage.clearAndEnterEmail(email);
        loginPage.clearAndEnterPassword(password);
        loginPage.clickOnLoginButton();

        navPage.clickOnMyProfilePageButton();

        profilePage.clearAndEnterProfileName(fullName);
        profilePage.clearAndEnterProfilePhone(phone);
        profilePage.clearAndEnterProfileCity(city);
        profilePage.clearAndEnterProfileCountry(country);
        profilePage.clearAndEnterProfileTwitter(twitter);
        profilePage.clearAndEnterProfileGitHub(github);
        profilePage.clickOnSaveButton();

        messagePopUpPage.waitForPopUpSuccessfullyMessageToShow();
        Assert.assertEquals(messagePopUpPage.getSuccessfullyMessageString(),expectedErrorMessage
                ,"");

        Assert.assertEquals(profilePage.getProfileEmailString(), email
                , "Actual field value doesn't match expected field value");
        Assert.assertEquals(profilePage.getProfileNameString(), fullName
                , "Actual field value doesn't match expected field value");
        Assert.assertEquals(profilePage.getProfilePhoneString(), phone
                , "Actual field value doesn't match expected field value");
        Assert.assertEquals(profilePage.getProfileCityString(), city
                , "Actual field value doesn't match expected field value");
        Assert.assertEquals(profilePage.getProfileCountryString(), country
                , "Actual field value doesn't match expected field value");
        Assert.assertEquals(profilePage.getProfileTwitterString(), twitter
                , "Actual attribute value doesn't match expected attribute value");
        Assert.assertEquals(profilePage.getProfileGitHubString(), github
                , "Actual attribute value doesn't match expected attribute value");

        navPage.clickOnLogOutButton();
    }
}
