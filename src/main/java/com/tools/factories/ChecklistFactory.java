package com.tools.factories;

import com.models.Card;
import com.models.Checklist;

public class ChecklistFactory {
    public static Checklist getChecklistInstance(String cardListId,String checklistName){
        Checklist checklist = new Checklist();
        checklist.setName(checklistName);
        checklist.setCardListId(cardListId);
        return checklist;
    }
    public static Checklist getChecklistItemInstance(String checklistName,String checklistId){
        Checklist checklist = new Checklist();
        checklist.setName(checklistName);
        checklist.setId(checklistId);
        return checklist;
    }
}
