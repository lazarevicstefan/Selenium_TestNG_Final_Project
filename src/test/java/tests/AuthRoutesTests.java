package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retry.RetryAnalyzer;

public class AuthRoutesTests extends BasicTest{
    @Test(priority = 1,retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated (){
        driver.navigate().to(baseUrl + "home");
        Assert.assertTrue(loginPage.verifyIsLoginPage()
                ,"Current URL should be " + baseUrl + "login");
    }
    @Test(priority = 2,retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated (){
        driver.navigate().to(baseUrl + "profile");
        Assert.assertTrue(loginPage.verifyIsLoginPage()
                ,"Current URL should be " + baseUrl + "login");
    }
    @Test(priority = 3,retryAnalyzer = RetryAnalyzer.class)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated (){
        driver.navigate().to(baseUrl + "admin/cities");
        Assert.assertTrue(loginPage.verifyIsLoginPage()
                ,"Current URL should be " + baseUrl + "login");
    }
}
