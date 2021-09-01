package com.steps.api;

import com.dao.board.BoardAbstractDao;
import com.dao.board.BoardDao;
import com.models.Board;
import com.tools.constants.ApiUrlConstants;
import com.tools.factories.BoardFactory;
import com.tools.utils.InstanceUtils;
import net.thucydides.core.annotations.Step;

public class BoardApiSteps extends AbstractApiSteps{
    private static final long serialVersionUID = 1L;
    public BoardAbstractDao boardDao=new BoardDao();

    @Step
    public void createBoard(String name){
        Board boardRequest= BoardFactory.getBoardByInstance(name);
        Board boardResponse=createResource(ApiUrlConstants.BOARD_CREATE,boardRequest,Board.class);
        InstanceUtils.mergeObjects(boardRequest,boardResponse);
        boardDao.saveBoard(boardRequest);
    }
    @Step
    public void deleteAllBoards(){
        Board[] boards=getResource(ApiUrlConstants.BOARDS_GET_ALL,Board[].class);
        for(Board board:boards)
            deleteResource(ApiUrlConstants.BOARD_GET,board.getId());
    }
    @Step
    public void deleteBoard(String name){
        Board board=boardDao.getBoardByName(name);
        deleteResource(ApiUrlConstants.BOARD_GET, board.getId());
    }
}
