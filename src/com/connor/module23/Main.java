package com.connor.module23;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        CardList cardList = new CardList();
        cardList.shuffle();

        SortBySuit sortBySuit = new SortBySuit();

        Collections.sort(cardList.getAsList(), sortBySuit);
        System.out.println("******* SORTED BY SUIT *******");
        for(Card c : cardList.getAsList()){
            System.out.println(c);
        }

        SortByFace sortByFace = new SortByFace();

        System.out.println("******* SORTED BY FACE *******");
        Collections.sort(cardList.getAsList(), sortByFace);
        for(Card c : cardList.getAsList()){
            System.out.println(c);
        }
    }

}
