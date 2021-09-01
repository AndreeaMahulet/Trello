package com.steps.api;

import com.dao.board.BoardAbstractDao;
import com.dao.board.BoardDao;
import com.dao.list.ListAbstractDao;
import com.dao.list.ListDao;
import com.google.inject.Inject;
import com.models.Board;
import com.models.List;
import com.tools.constants.ApiUrlConstants;
import com.tools.factories.ListFactory;
import com.tools.utils.InstanceUtils;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ListApiSteps extends AbstractApiSteps{
    private static final long serialVersionUID = 1L;
    private BoardAbstractDao boardDao=new BoardDao();
    public ListAbstractDao listDao=new ListDao();
    @Step
    public void addListInBoard(String boardName, String listName) {
        Board board = boardDao.getBoardByName(boardName);
        List listRequest = ListFactory.getListInstance(board.getId(), listName);
        List listResponse = createResource(ApiUrlConstants.LIST_CREATE, listRequest, List.class);
        InstanceUtils.mergeObjects(listRequest, listResponse);
        listDao.saveList(listRequest);
    }
    public List getListFromServer(String name) {
        List expectedList = listDao.getListByName(name);
        return getResource(ApiUrlConstants.LIST_GET, List.class, expectedList.getId());
    }

    @Step
    public void verifyListIsPresent(String name) {
        Assert.assertTrue("List is not present!", listDao.getListByName(name).equals(getListFromServer(name)));
    }
    @Step
    public void updateListName(String name, String newName){
        List listRequest=listDao.getListByName(name);
        listRequest.setName(newName);
        updateResource(ApiUrlConstants.LIST_GET,listRequest,listRequest.getId());
        listDao.updateList(newName,listRequest);
    }
    @Step
    public void archiveList(String name){
        List listRequest=listDao.getListByName(name);
        listRequest.setClosed(true);
        updateResource(ApiUrlConstants.LIST_GET,listRequest,listRequest.getId());
        listDao.updateList(name,listRequest);
    }
    @Step
    public void verifyListIsArchived(String name) {
        Assert.assertTrue("List is not archived!", getListFromServer(name).isClosed());
    }
}
