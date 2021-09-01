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
    public Checklist getChecklistByName(String name) {
        return getAllChecklists().parallelStream().filter(item -> item.getName().contentEquals(name)).findFirst().orElse(null);
    }

    @Override
    public void updateChecklist(String name, Checklist newChecklist) {
        try {
            SerenitySessionUtils.replaceObjectInSerenitySessionList(SerenityKeyConstants.CHECKLIST, newChecklist,
                    "name", name);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
