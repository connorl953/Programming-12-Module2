package com.connor.module22;
import java.util.Arrays;
public class Main {

    public static void main(String[] args) {
        CardList cardList = new CardList();
        cardList.shuffle();
        System.out.println(Arrays.toString(cardList.pollHand().toArray()));

    }

}
