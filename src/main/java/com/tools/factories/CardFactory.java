package com.tools.factories;

import com.models.Card;

public class CardFactory {
    public static Card getCardInstance(String boardId, String name){
        Card card = new Card();
        card.setName(name);
        card.setBoardListId(boardId);
        return card;
    }
}
