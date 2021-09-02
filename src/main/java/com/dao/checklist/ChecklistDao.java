package com.dao.checklist;

import com.models.Checklist;
import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ChecklistDao implements ChecklistAbstractDao{

    @Override
    public void saveChecklist(Checklist checklist) {
        System.out.println("Saving checklist " + checklist.getName() + " ...");
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.CHECKLIST, checklist);
    }

    @Override
    public List<Checklist> getAllChecklists() {
        return SerenitySessionUtils.getFromSession(SerenityKeyConstants.CHECKLIST);
    }

    @Override
    public Checklist getChecklistById(String idCard) {
        return getAllChecklists().parallelStream().filter(item -> item.getId().contentEquals(idCard)).findFirst().orElse(null);
    }
    @Override
    public Checklist getChecklistByName(String name) {
        return getAllChecklists().parallelStream().filter(item -> item.getName().contentEquals(name)).findFirst().orElse(null);
    }

    @Override
    public void updateChecklist(String idCard, Checklist newChecklist) {
        try {
            SerenitySessionUtils.replaceObjectInSerenitySessionList(SerenityKeyConstants.CHECKLIST, newChecklist,
                    "idCard", idCard);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
