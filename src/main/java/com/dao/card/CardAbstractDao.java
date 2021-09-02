package com.dao.card;

import com.google.inject.ImplementedBy;
import com.models.Card;

import java.util.List;

@ImplementedBy(CardDao.class)
public interface CardAbstractDao {
    public void saveCard(Card card);

    public List<Card> getAllCards();

    public Card getCardByName(String name);
    public Card getCardById(String id);

    public void updateCard(String name, Card newCard);

}
