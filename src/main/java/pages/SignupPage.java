package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasicPage{
    public SignupPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean verifyIsSignupPage(){
        try{
            if (driver.getCurrentUrl().contains("/signup")){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public void clearAndEnterName (String fullName){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("name")))
                        .sendKeys(fullName);
    }
    public void clearAndEnterEmail (String email){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("email")))
                        .sendKeys(email);
    }
    public void clearAndEnterPassword (String password){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("password")))
                        .sendKeys(password);
    }
    public void clearAndEnterPasswordConfirm (String passwordConfirm){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("confirmPassword")))
                        .sendKeys(passwordConfirm);
    }
    public void clickOnSignMeUpButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[text()='Sign me up']")))
                        .click();
    }

    public WebElement getNameElement (){
        return driver.findElement(By.id("name"));
    }
    public WebElement getEmailElement (){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordElement (){
        return driver.findElement(By.id("password"));
    }
    public WebElement getPasswordConfirmElement (){
        return driver.findElement(By.id("confirmPassword"));
    }
    public WebElement getSignMeUpElement() {
        return driver.findElement(By.xpath("//*[text()='Sign me up']"));
    }
}
