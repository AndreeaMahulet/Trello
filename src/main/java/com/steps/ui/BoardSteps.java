package com.steps.ui;

import com.pages.BoardPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;

public class BoardSteps extends ScenarioSteps {
    private static final long serialVersionUID = 1L;
    private BoardPage boardPage;

     @Step
    public void addCardInTheList(String listName, String cardName){
         boardPage.createCardOnTheList(listName,cardName);
     }
     @Step
    public void checkThatCardIsPresentInTheList(String listName, String cardName){
         Assert.assertTrue(String.format("%s card was not found!", cardName), boardPage.getCardContainer(listName, cardName).isDisplayed());
     }

}
