package com.dao.checklistItem;

import com.models.ChecklistItem;

import java.util.List;

public interface ChecklistItemAbstractDao {
    public void saveChecklist(ChecklistItem checklist);

    public List<ChecklistItem> getAllChecklists();

    public ChecklistItem getChecklistById(String cardId);
    public ChecklistItem getChecklistByName(String name);
    public void updateChecklist(String name, ChecklistItem newChecklist);
}
