package com.steps.api;

import com.dao.card.CardAbstractDao;
import com.dao.card.CardDao;
import com.dao.checklist.ChecklistAbstractDao;
import com.dao.checklist.ChecklistDao;
import com.dao.list.ListAbstractDao;
import com.dao.list.ListDao;
import com.models.Card;
import com.models.Checklist;
import com.models.List;
import com.tools.constants.ApiUrlConstants;
import com.tools.factories.CardFactory;
import com.tools.factories.ChecklistFactory;
import com.tools.utils.InstanceUtils;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

public class CardApiSteps extends AbstractApiSteps{
    private static final long serialVersionUID = 1L;
    @Steps
    private BoardApiSteps boardApiSteps;
    ListAbstractDao listDao=new ListDao();
    CardAbstractDao cardDao=new CardDao();
    ChecklistAbstractDao checklistDao=new ChecklistDao();
    @Step
    public void createCard(String listName, String cardName) {
        List list = listDao.getListByName(listName);
        Card cardRequest = CardFactory.getCardInstance(list.getId(), cardName);
        Card cardResponse = createResource(ApiUrlConstants.CARD_CREATE, cardRequest, Card.class);
        InstanceUtils.mergeObjects(cardRequest, cardResponse);
        cardDao.saveCard(cardRequest);
    }
    public Card getCardFromServer(String name) {
        Card expectedCard = cardDao.getCardByName(name);
        return getResource(ApiUrlConstants.CARD_GET, Card.class, expectedCard.getId());
    }
    @Step
    public void verifyCardIsPresent(String name) {
        Assert.assertTrue("Card is not present!", cardDao.getCardByName(name).equals(getCardFromServer(name)));
    }
    @Step
    public void updateCardName(String name, String newName){
        Card cardRequest=cardDao.getCardByName(name);
        cardRequest.setName(newName);
        updateResource(ApiUrlConstants.CARD_GET,cardRequest,cardRequest.getId());
//        cardRequest.setName(newName);
        cardDao.updateCard(newName,cardRequest);
    }
    @Step
    public void deleteCard(String name){
        Card cardRequest=cardDao.getCardByName(name);
        deleteResource(ApiUrlConstants.CARD_GET,cardRequest.getId());
    }
    @Step
    public void verifyCardIsNotPresent(String name){
        Card expectedCard=cardDao.getCardByName(name);
        Assert.assertTrue("Card is not present!",getNotFoundResourceMessage(ApiUrlConstants.CARD_GET,
                getCommonBodyParams(),expectedCard.getId()).equals("The requested resource was not found."));
    }
    @Step
    public void updateCardList(String cardName, String newListName) {
        Card cardRequest = cardDao.getCardByName(cardName);
        List list = listDao.getListByName(newListName);
        cardRequest.setBoardListId(list.getId());
        updateResource(ApiUrlConstants.CARD_GET, cardRequest, cardRequest.getId());
        cardDao.updateCard(cardName, cardRequest);
    }
    @Step
    public void createCheckList(String listName, String cardName) {
        Checklist checklist = checklistDao.getChecklistByName(listName);
        Checklist checklistRequest = ChecklistFactory.getChecklistInstance(checklist.getId(), cardName);
        Checklist checklistResponse = createResource(ApiUrlConstants.CHECKLIST_CREATE, checklistRequest, Checklist.class);
        InstanceUtils.mergeObjects(checklistRequest, checklistResponse);
        checklistDao.saveChecklist(checklistRequest);
    }
}
