package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasicPage {
    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean verifyIsNavPageIsOnLanguage(String h1text){
        try{
            if (driver.findElement(By.tagName("h1")).getText().equals(h1text)){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }
    public boolean verifyIsHomePage(){
        try{
            Thread.sleep(1000);
            if (driver.getCurrentUrl().contains("/home")){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public void clickOnHomePageButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//div[@class='v-toolbar__items']/a[@href='/home']")))
                        .click();
    }
    public void clickOnAboutPageButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//div[@class='v-toolbar__items']/a[@href='/about']")))
                        .click();
    }
    public void clickOnMyProfilePageButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("btnProfile")))
                        .click();
    }
    public void clickOnAdminDropdownButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("btnAdmin")))
                        .click();
    }
    public void clickOnCitiesButtonFromAdminDropdown() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("btnAdminCities")))
                        .click();
    }
    public void clickOnUsersButtonFromAdminDropdown() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("btnAdminUsers")))
                        .click();
    }
    public void clickOnSignUpButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[text()=' Sign Up ']")))
                        .click();
    }
    public void clickOnLoginButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(@class, 'btnLogin')]")))
                        .click();
    }
    public void clickOnLogOutButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("btnLogout")))
                        .click();
    }
    public void clickOnLanguageDropdownButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.className("btnLocaleActivation")))
                        .click();
    }
    public void clickOnENButtonFromLanguageDropdown(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(@role, 'menu')]/div/div[1]")))
                        .click();
    }
    public void clickOnESButtonFromLanguageDropdown(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(@role, 'menu')]/div/div[2]")))
                        .click();
    }
    public void clickOnFRButtonFromLanguageDropdown(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(@role, 'menu')]/div/div[3]")))
                        .click();
    }
    public void clickOnCNButtonFromLanguageDropdown(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(@role, 'menu')]/div/div[4]")))
                        .click();
    }
    public void clickOnUAButtonFromLanguageDropdown(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[contains(@role, 'menu')]/div/div[5]")))
                        .click();
    }

    public WebElement getHomePageElement() {
        return driver.findElement(By.xpath("//*[text()=' Home ']"));
    }

    public WebElement getAboutPageElement() {
        return driver.findElement(By.xpath("//*[text()=' About ']"));
    }
    public WebElement getMyProfilePageElement() {
        return driver.findElement(By.className("btnProfile"));
    }
    public WebElement getAdminDropdownElement() {
        return driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesFromAdminDropdownElement() {
        return driver.findElement(By.className("btnAdminCities"));
    }
    public WebElement getUsersFromAdminDropdownElement() {
        return driver.findElement(By.className("btnAdminUsers"));
    }
    public WebElement getSignUpElement() {
        return driver.findElement(By.xpath("//*[text()=' Sign Up ']"));
    }
    public WebElement getLoginElement() {
        return driver.findElement(By.xpath("//*[contains(@class, 'btnLogin')]"));
    }
    public WebElement getLogOutElement() {
        return driver.findElement(By.className("btnLogout"));
    }
    public WebElement getLanguageDropdownElement() {
        return driver.findElement(By.className("btnLocaleActivation"));
    }
    public WebElement getENFromLanguageDropdownElement(){
        return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[1]"));
    }
    public WebElement getESFromLanguageDropdownElement(){
        return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[2]"));
    }
    public WebElement getFRFromLanguageDropdownElement(){
        return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[3]"));
    }
    public WebElement getCNFromLanguageDropdownElement(){
        return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[4]"));
    }
    public WebElement getUAFromLanguageDropdownElement(){
        return driver.findElement(By.xpath("//*[contains(@role, 'menu')]/div/div[5]"));
    }
}
