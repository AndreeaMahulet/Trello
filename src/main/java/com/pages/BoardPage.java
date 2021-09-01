package com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BoardPage extends GeneralPage{
    @FindBy(css=".list-card-composer-textarea")
    private WebElement cardTitleInput;
    @FindBy(css=".list-cards a")
    private WebElement listButton;

    public WebElement getListContainer(String name){
        return getDriver().findElement(By.xpath("//div[contains(@class,'list-wrapper')][div/div/textarea[text()='"+ name + "']]"));
    }
    public void createCardOnTheList(String listName, String cardName){
        getListContainer(listName).findElement(By.cssSelector(".icon-add")).click();
        cardTitleInput.sendKeys(cardName);
        getElementWithValueAttribute("Add card").click();
    }
    public WebElement getCardContainer(String listName, String cardName) {
        return getListContainer(listName).findElement(By.xpath("//div[contains(@class,'list-card')][span[text()='" + cardName + "']]"));
    }
    public void clickOnListButton(){
        clickOn(listButton);
    }
}
