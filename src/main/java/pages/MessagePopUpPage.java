package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasicPage {
    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForPopUpDialogToVisible() {
        wait.until(ExpectedConditions.attributeContains(By
                .xpath("//*[contains(@class, 'background ')]"), "class", "v-snack--active"));
    }

    public String getPopUpMessageString() {
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//*[contains(@class, 'background ')]//li")))
                                        .getText();
    }

    public WebElement getPopUpMessageElement() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//*[contains(@class, 'background ')]//li")));
    }
    public void clickOnCloseButton (){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//*[contains(@class, 'v-snack__content')]/button")))
                                .click();
    }
    public WebElement getCloseButtonElement (){
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//*[contains(@class, 'v-snack__content')]/button")));
    }
    public void waitForVerifyYourAccountToBeVisible() {
        wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By
                        .className("dlgVerifyAccount")));
    }
    public String getTextFromVerifyYourAccount() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//*[contains(@class, 'v-card__title') " +
                                "and contains(@class, 'dlgVerifyAccount')]")))
                                        .getText();
    }
    public void clickOnCloseButtonFromVerifyYourAccount(){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//*[contains(@class, 'v-card__actions')]/button")))
                                .click();
    }
    public WebElement getCloseButtonFromVerifyYourAccountElement(){
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//*[contains(@class, 'v-card__actions')]/button")));
    }
}
