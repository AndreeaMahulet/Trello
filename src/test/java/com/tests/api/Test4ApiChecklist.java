package com.tests.api;

import net.bytebuddy.utility.RandomString;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class Test4ApiChecklist extends BaseApiTest{
    private String listName= RandomString.make(10);
    private String cardName=RandomString.make(10);
    private String cardNewName=RandomString.make(15);
    private String checklistName= RandomString.make(10);
    private String checklistItem= RandomString.make(10);


    @Test
    public void testChecklist(){
        listApiSteps.addListInBoard(boardName,listName);
        cardApiSteps.createCard(listName,cardName);
        cardApiSteps.verifyCardIsPresent(cardName);
        cardApiSteps.createCheckList(cardName,checklistName);
        cardApiSteps.createCheckItem(checklistName,checklistItem);
        cardApiSteps.deleteCard(cardName);
        cardApiSteps.verifyCardIsNotPresent(cardName);
    }
}
