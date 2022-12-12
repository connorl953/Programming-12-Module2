package com.connor.module23;

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


    public int getSuitValue(){
        switch(this.suit){
            case SPADES: return 4;
            case HEARTS: return 3;
            case DIAMONDS: return 2;
            case CLUBS: return 1;
            default: return -1;
        }
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
