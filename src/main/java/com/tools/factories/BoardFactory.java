package com.tools.factories;

import com.models.Board;

public class BoardFactory {
    public static Board getBoardByInstance(String name){
        Board board=new Board();
        board.setName(name);
        return board;
    }
}
