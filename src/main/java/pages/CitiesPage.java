package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasicPage{
    public CitiesPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
    public boolean verifyIsAdminCitiesPage(){
        try{
            if (driver.getCurrentUrl().contains("/admin/cities")){
                return true;
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public void clickOnNewItemButton() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//form//button")))
                        .click();
    }
    public void clearAndEnterNameInNewItem (String name){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("name"))).clear();
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("name"))).sendKeys(name);
    }
    public void waitForEditDialogToBeCloseAndCitiesIsShow (){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//*[contains(@class, 'dialog__content--active')]/div/div")));
    }
    public void waitForNewItemAndDeleteDialogToBeShow (){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .className("v-dialog--active")));
    }
    public void clickOnSaveButtonInEditAndCreateDialog (){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .className("btnSave"))).click();
    }
    public void clickOnDeleteButtonInDeleteDialog (){
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .xpath("//*[contains(@class, 'v-dialog--active')]//button[2]"))).click();
    }
    public void waitForTableToShowInputtedRows (int rows){
        wait.until(ExpectedConditions
                .numberOfElementsToBe(By.tagName("tr"), rows + 1));
    }
    public String getCellFromInputtedRowAndColumnString (int row, int column){
        return driver.findElement(By
                .xpath("//tbody/tr[" + row + "]/td[" + column + "]")).getText();
    }
    public WebElement getCellFromInputtedRowAndColumnElement (int row, int column){
        return driver.findElement(By
                .xpath("//tbody/tr[" + row + "]/td[" + column + "]"));
    }
    public void clickOnEditButtonFromRow (int row){
        driver.findElement(By.xpath("//tbody/tr[" + row + "]"))
                .findElement(By.id("edit")).click();
    }
    public WebElement getEditButtonFromRowElement (int row){
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]"))
                .findElement(By.id("edit"));
    }
    public void clickOnDeleteButtonFromRow (int row){
        driver.findElement(By.xpath("//tbody/tr[" + row + "]"))
                .findElement(By.id("delete")).click();
    }
    public WebElement getDeleteButtonFromRowElement (int row){
        return driver.findElement(By.xpath("//tbody/tr[" + row + "]"))
                .findElement(By.id("delete"));
    }
    public WebElement getNewItemButtonElement() {
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .xpath("//form//button")));
    }
    public WebElement getEnterNameInNewItemElement (){
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.id("name")));
    }

    public WebElement getSaveButtonInEditDialogElement (){
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By
                                .className("btnSave")));
    }
    public WebElement getDeleteButtonInDeleteDialogElement (){
        return wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By
                            .xpath("//*[contains(@class, 'v-dialog--active')]//button[2]")));
    }
}
