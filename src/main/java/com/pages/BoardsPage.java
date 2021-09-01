package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Locale;

public class BoardsPage extends GeneralPage{
    public WebElement getBoardContainer(String name) {
        List<WebElement> boards=getDriver().findElements(By.cssSelector(".boards-page-board-section-list-item"));
        WebElement board=boards.stream().filter(element->element.getText().toLowerCase().contentEquals(name.toLowerCase()))
                .findAny().orElse(null);
        return board;
    }
    public void openBoard(String name){
        waitForTextToAppear(name);
        getBoardContainer(name).click();
    }
}
