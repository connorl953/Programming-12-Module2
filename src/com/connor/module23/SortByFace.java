package com.connor.module23;

import java.util.Comparator;

public class SortByFace implements Comparator<Card> {

    /**
     *
     * @param o1 Card 1
     * @param o2 Card 2
     * @return Positive if card 2 is face card, 0 if both are/aren't face cards, negative if card 1 is face card
     * Does not sort by value of face cards.
     */
    @Override
    public int compare(Card o1, Card o2) {

        if(o1.isFaceCard() && o2.isFaceCard()){
            return 0;
        } else {
            return o2.isFaceCard() ? 1 : -1;
        }
    }
}
