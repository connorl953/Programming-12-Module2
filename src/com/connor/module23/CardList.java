package com.connor.module23;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CardList {
    LinkedList<Card> cardList;
    public CardList() {
        this.cardList = new LinkedList<>();
        createDeck();
    }

    public List<Card> getAsList(){
        return this.cardList;
    }

    public void addCard(Card card) {
        cardList.add(card);
    }

    public void shuffle(){
        Collections.shuffle(cardList);
    }

    private void createDeck() {
        for (Suit suit : Suit.values()) {
            for (int i = 1; i <= 13; i++) {
                boolean isFaceCard = (i > 10);
                Card card = new Card(suit, i, isFaceCard);
                addCard(card);
            }
        }
    }

    private Card pollCard(){
        return cardList.poll();
    }

    public List<Card> pollHand() {
        List<Card> hand = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Card card = this.pollCard();
            hand.add(card);
        }
        return hand;
    }



}
