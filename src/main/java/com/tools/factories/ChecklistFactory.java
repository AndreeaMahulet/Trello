package com.tools.factories;

import com.models.Card;
import com.models.Checklist;
import com.models.ChecklistItem;

public class ChecklistFactory {
    public static Checklist getChecklistInstance(String cardListId,String checklistName){
        Checklist checklist = new Checklist();
        ChecklistItem checklistItem=new ChecklistItem();
        checklist.setName(checklistName);
        checklist.setCardListId(cardListId);
        return checklist;
    }
    public static Checklist getChecklistItemInstance(String checklistName,String checklistId,String cardListId){
        Checklist checklist = new Checklist();
        ChecklistItem checklistItem=new ChecklistItem();
        checklist.setName(checklistName);
        checklist.setId(checklistId);
        checklist.setCardListId(cardListId);
        return checklist;
    }
    public static Checklist getItemInstance(String cardListId,String checklistName){
        Checklist checklist = new Checklist();
        checklist.setName(checklistName);
        checklist.setCardListId(cardListId);
        return checklist;
    }
    public static Checklist getChecklistItemId(String itemId,String checklistName,String cardListId,String checklistId){
        Checklist checklist = new Checklist();
        checklist.setChecklistItemId(itemId);
        checklist.setName(checklistName);
        checklist.setCardListId(cardListId);
        checklist.setId(checklistId);
        return checklist;
    }
}
