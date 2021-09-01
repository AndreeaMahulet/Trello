package com.tools.factories;

import com.models.Checklist;

public class ChecklistFactory {
    public static Checklist getChecklistInstance(String boardId, String name){
        Checklist checklist = new Checklist();
        checklist.setName(name);
        checklist.setBoardListId(boardId);
        return checklist;
    }
}
