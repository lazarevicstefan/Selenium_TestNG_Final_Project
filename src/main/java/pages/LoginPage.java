package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasicPage{

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);

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
    public void clickOnLoginButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//button/span[text()='Login']")))
                        .click();
    }
    public WebElement getEmailElement (){
        return driver.findElement(By.id("email"));
    }
    public WebElement getPasswordElement (){
        return driver.findElement(By.id("password"));
    }
    public WebElement getLoginButtonElement (){
        return driver.findElement(By.xpath("//button/span[text()='Login']"));
    }
    public boolean verifyIsLoginPage(){
        try{
            if (driver.getCurrentUrl().contains("/login")){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
}
