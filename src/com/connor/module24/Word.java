package com.connor.module24;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word {
    /**
     *
     This method takes a File as a parameter and returns the number of unique words in the file. It uses a Scanner to read the file line by line and a Pattern to match words. It stores the words in a HashSet to ensure that each word is only counted once.
     * @param file a file containing text.
     * @return Integer representing the number of unique words in a given file
     * @throws FileNotFoundException When the file cannot be read
     */
    public static int countUniqueWords(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        Pattern pattern = Pattern.compile("\\b[A-Za-z]+\\b");
        HashSet<String> words = new HashSet<>();
        while(scanner.hasNextLine()) {
            Matcher matcher = pattern.matcher(scanner.nextLine());
            while(matcher.find()){
                String currentWord = matcher.group().toLowerCase();
                words.add(currentWord);
            }
        }
        return words.size();
    }
}
