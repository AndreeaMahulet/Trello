package com.dao.board;

import com.google.inject.ImplementedBy;
import com.models.Board;

import java.util.List;

@ImplementedBy(BoardDao.class)
public interface BoardAbstractDao {
    public Board getBoardByName(String name);

    public void saveBoard(Board board);

    public List<Board> getAllBoards();
}
