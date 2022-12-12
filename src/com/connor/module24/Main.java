package com.connor.module24;

import java.io.File;
import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File illiad = new File("src/com/connor/module24/illiad.txt");
        System.out.println("There are " + Word.countUniqueWords(illiad) + " unique words in the Illiad.");
    }
}
