package com.connor.module23;

import java.util.Comparator;

public class SortBySuit implements Comparator<Card> {


    /**
     *
     * @param o1 Card 1
     * @param o2 Card 2
     * @return Sorts in this order: SPADES > HEARTS > DIAMONDS > CLUBS
     */
    @Override
    public int compare(Card o1, Card o2) {
        return o2.getSuitValue()-o1.getSuitValue();
    }
}
