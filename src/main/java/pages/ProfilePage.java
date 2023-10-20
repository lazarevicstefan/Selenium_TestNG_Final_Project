package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasicPage{
    public ProfilePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean verifyIsProfilePage(){
        try{
            Thread.sleep(1000);
            if (driver.getCurrentUrl().contains("/profile")){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
    public String getValueForDisableEmail (){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return arguments[0].getAttribute('disabled');"
                , getProfileEmailElement()).toString();

    }
    public String getProfileEmailString (){
        return getProfileEmailElement()
                        .getAttribute("value");
    }
    public WebElement getProfileEmailElement (){
        return driver.findElement(By.id("email"));
    }
    public String getProfileNameString (){
        return getProfileNameElement()
                .getAttribute("value");
    }
    public WebElement getProfileNameElement (){
        return driver.findElement(By.id("name"));
    }
    public String getProfilePhoneString (){
        return getProfilePhoneElement()
                .getAttribute("value");
    }
    public WebElement getProfilePhoneElement(){
        return driver.findElement(By.id("phone"));
    }
    public String getProfileCityString (){
        return getProfileCityElement()
                .getAttribute("value");
    }
    public WebElement getProfileCityElement(){
        return driver.findElement(By.id("city"));
    }
    public String getProfileCountryString (){
        return getProfileCountryElement()
                .getAttribute("value");
    }
    public WebElement getProfileCountryElement (){
        return driver.findElement(By.id("country"));
    }
    public String getProfileTwitterString (){
        return getProfileTwitterElement()
                .getAttribute("value");
    }
    public WebElement getProfileTwitterElement (){
        return driver.findElement(By.id("urlTwitter"));
    }
    public String getProfileGitHubString (){
        return getProfileGitHubElement()
                .getAttribute("value");
    }
    public WebElement getProfileGitHubElement (){
        return driver.findElement(By.id("urlGitHub"));
    }





    public void clearAndEnterProfileName (String name){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("name")))
                                .clear();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("name")))
                                .sendKeys(name);
    }
    public void clearAndEnterProfilePhone (String phone){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("phone")))
                                .clear();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("phone")))
                                .sendKeys(phone);
    }
    public void clearAndEnterProfileCity (String city){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("city")))
                                .clear();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("city")))
                                .sendKeys(city);
    }
    public void clearAndEnterProfileCountry (String country){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("country")))
                                .clear();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("country")))
                                .sendKeys(country);
    }
    public void clearAndEnterProfileTwitter (String urlTwitter){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("urlTwitter")))
                                .clear();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("urlTwitter")))
                                .sendKeys(urlTwitter);
    }
    public void clearAndEnterProfileGitHub (String urlGitHub){
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("urlGitHub")))
                                .clear();
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.name("urlGitHub")))
                                .sendKeys(urlGitHub);
    }
}
