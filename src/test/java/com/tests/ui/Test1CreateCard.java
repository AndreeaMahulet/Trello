package com.tests.ui;

import net.bytebuddy.utility.RandomString;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class Test1CreateCard extends BaseTest{
    private String firstListName = RandomString.make(10);
    private String secondListName = RandomString.make(10);
    private String cardName = RandomString.make(10);
    @Before
    public void dataPrep(){
        boardApiSteps.createBoard(boardName);
        listApiSteps.addListInBoard(boardName,firstListName);
        listApiSteps.addListInBoard(boardName,secondListName);
        loginSteps.login();
        boardsSteps.openBoard(boardName);
    }
    @Test
    public void test1CreateCard(){
        boardSteps.addCardInTheList(firstListName,cardName);
        boardSteps.addCardInTheList(secondListName,cardName);
        boardSteps.checkThatCardIsPresentInTheList(firstListName,cardName);
        boardSteps.checkThatCardIsPresentInTheList(secondListName,cardName);
    }
    @After
    public void tearDown(){
        boardApiSteps.deleteBoard(boardName);
    }
}
