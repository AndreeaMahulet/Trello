package com.tests.api;

import net.bytebuddy.utility.RandomString;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)

public class Test3ApiCrudList extends BaseApiTest{
    private String listName = RandomString.make(10);
    private String listNewName = RandomString.make(15);

    @Test
    public void testCrudList(){
        listApiSteps.addListInBoard(boardName,listName);
        listApiSteps.verifyListIsPresent(listName);
        listApiSteps.updateListName(listName,listNewName);
        listApiSteps.verifyListIsPresent(listNewName);
        listApiSteps.archiveList(listNewName);
        listApiSteps.verifyListIsArchived(listNewName);
    }
}
