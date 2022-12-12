package com.connor.module22;

public class Card {
    private Suit suit;
    private int value;
    private boolean isFaceCard;

    public Card(Suit suit, int value, boolean isFaceCard) {
        this.suit = suit;
        this.value = value;
        this.isFaceCard = isFaceCard;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isFaceCard() {
        return isFaceCard;
    }

    private String getCardName(){
        switch(value){
            case 1: return "Ace";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return String.valueOf(this.value);
        }
    }

    @Override
    public String toString(){
        return getCardName() + " of " + suit;
    }
}
