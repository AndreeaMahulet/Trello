package com.dao.board;

import com.models.Board;
import com.tools.constants.SerenityKeyConstants;
import com.tools.utils.SerenitySessionUtils;

import java.util.List;

public class BoardDao implements BoardAbstractDao {

    @Override
    public Board getBoardByName(String name) {
        return getAllBoards().parallelStream().filter(item -> item.getName().contentEquals(name)).findFirst().orElse(null);
    }

    @Override
    public void saveBoard(Board board) {
        System.out.println("Saving board " + board.getName() + " ...");
        SerenitySessionUtils.saveObjectInSerenitySessionList(SerenityKeyConstants.BOARD, board);

    }

    @Override
    public List<Board> getAllBoards() {
        return SerenitySessionUtils.getFromSession(SerenityKeyConstants.BOARD);
    }

}
