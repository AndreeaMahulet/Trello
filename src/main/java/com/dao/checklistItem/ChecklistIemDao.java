package com.dao.checklistItem;

import com.models.ChecklistItem;
import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ChecklistIemDao implements ChecklistItemAbstractDao{
    @Override
    public void saveChecklist(ChecklistItem checklistItem) {
        System.out.println("Saving checklist item " + checklistItem.getName() + " ...");
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.CHECKLIST, checklistItem);
    }

    @Override
    public List<ChecklistItem> getAllChecklists() {
        return SerenitySessionUtils.getFromSession(SerenityKeyConstants.CHECKLIST);
    }

    @Override
    public ChecklistItem getChecklistById(String idCard) {
        return getAllChecklists().parallelStream().filter(item -> item.getId().contentEquals(idCard)).findFirst().orElse(null);
    }
    @Override
    public ChecklistItem getChecklistByName(String name) {
        return getAllChecklists().parallelStream().filter(item -> item.getName().contentEquals(name)).findFirst().orElse(null);
    }

    @Override
    public void updateChecklist(String idCard, ChecklistItem newChecklist) {
        try {
            SerenitySessionUtils.replaceObjectInSerenitySessionList(SerenityKeyConstants.CHECKLIST, newChecklist,
                    "idCard", idCard);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
