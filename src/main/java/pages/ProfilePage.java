package pages;

import org.openqa.selenium.*;
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
    public void clickOnSaveButton (){
        driver.findElement(By.cssSelector(".flex.text-xs-center.mt-5 > button")).click();
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
        try {
            Thread.sleep(1000);
            wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.id("name")))
                    .sendKeys(Keys.CONTROL,"a", Keys.DELETE);
            wait.until(ExpectedConditions
                            .visibilityOfElementLocated(By.id("name")))
                    .sendKeys(name);
        }catch (Exception e){}
    }
    public void clearAndEnterProfilePhone (String phone){
        try {
            Thread.sleep(1000);
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("phone")))
                                .sendKeys(Keys.CONTROL,"a", Keys.DELETE);
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("phone")))
                                .sendKeys(phone);
        }catch (Exception e){}
    }
    public void clearAndEnterProfileCity (String city){
        driver.findElement(By.id("city")).click();
        driver.findElement(By
                        .xpath("//*[contains(text(), '" + city + "')]"))
                .click();
    }
    public void clearAndEnterProfileCountry (String country){
        try {
            Thread.sleep(1000);
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("country")))
                                .sendKeys(Keys.CONTROL,"a", Keys.DELETE);
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("country")))
                                .sendKeys(country);
        }catch (Exception e){}
    }
    public void clearAndEnterProfileTwitter (String urlTwitter){
        try {
            Thread.sleep(1000);
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("urlTwitter")))
                                .sendKeys(Keys.CONTROL,"a", Keys.DELETE);
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("urlTwitter")))
                                .sendKeys(urlTwitter);
        }catch (Exception e){}
    }
    public void clearAndEnterProfileGitHub (String urlGitHub){
        try {
            Thread.sleep(1000);
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("urlGitHub")))
                                .sendKeys(Keys.CONTROL,"a", Keys.DELETE);
        wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("urlGitHub")))
                                .sendKeys(urlGitHub);
        }catch (Exception e){}
    }
}
