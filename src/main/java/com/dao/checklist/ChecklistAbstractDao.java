package com.dao.checklist;

import com.models.Checklist;

import java.util.List;

public interface ChecklistAbstractDao {
    public void saveChecklist(Checklist checklist);

    public List<Checklist> getAllChecklists();

    public Checklist getChecklistById(String cardId);
    public Checklist getChecklistByName(String name);
    public void updateChecklist(String name, Checklist newChecklist);
}
