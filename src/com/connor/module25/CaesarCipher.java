package com.connor.module25;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaesarCipher {

    private String message;
    private int offset;
    private HashSet<String> dictionary;

    public CaesarCipher(String message, int offset) {
        this.message = message.toLowerCase();
        this.offset = offset % 26;
        this.dictionary = generateDictionary();
    }

    /**
     * Generates a HashSet of all words given by "words_alpha.txt"
     * @return a HashSet of all words given by "words_alpha.txt"
     */
    private HashSet<String> generateDictionary(){
        try {
            File wordsAlpha = new File("src/com/connor/module25/words_alpha.txt");
            if(wordsAlpha.exists()) {
                HashSet<String> dictionary = new HashSet<>();
                Scanner s = new Scanner(wordsAlpha);
                while (s.hasNextLine()) {
                    dictionary.add(s.nextLine());
                }
                return dictionary;
            } else {
                return null;
            }
        } catch(Exception e){
            return null;
        }
    }

    public String encrypt() {
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'z') {
                toReturn.append(applyOffset(c, offset));
            } else {
                toReturn.append(c);
            }
        }
        return toReturn.toString();
    }


    /**
     * This method decrypts a given message using a given offset.
     * It iterates through each character in the message and applies the offset to each character if it is a lowercase letter.
     * It then returns the decrypted message as a String.
     *
     * @return The decrypted message as a String
     */
    public String decrypt() {
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'z') {
                toReturn.append(applyOffset(c, this.offset * -1));
            } else {
                toReturn.append(c);
            }
        }
        return toReturn.toString();
    }

    private String decrypt(String message, int offset) {
        message = message.toLowerCase();
        StringBuilder toReturn = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c >= 'a' && c <= 'z') {
                toReturn.append(applyOffset(c, offset * -1));
            } else {
                toReturn.append(c);
            }
        }
        return toReturn.toString();
    }

    private static char applyOffset(char c, int offset) {
        int offset_applied_ascii = (int)c+offset;
        int ascii_max = 122;
        int ascii_min = 97;
        if (offset_applied_ascii > ascii_max) {
            return (char) (ascii_min + (offset_applied_ascii - ascii_max) - 1);
        } else if (offset_applied_ascii < ascii_min) {
            return (char) (ascii_max - (ascii_min - offset_applied_ascii) + 1);
        } else {
            return (char) offset_applied_ascii;
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method attempts to crack a given message using a Caesar cipher. It does this by looping through all possible offsets from 0 to 25 and counting the number of words in the decrypted message for each offset. The offset with the highest word count is then used to decrypt the message and is returned with the offset.
     *
     * @param message The message to be decrypted
     * @return The decrypted message with the offset used to decrypt it
     */
    public String crack(String message) {
        HashMap<Integer, Integer> attempts = new HashMap<>();
        for (int i = 0; i <= 25; i++) {
        attempts.put(i, countWords(decrypt(message, i)));
        }
        int bestOffset = 0;
        int bestCount = 0;
        for (int key : attempts.keySet()) {
            if (attempts.get(key) > bestCount) {
                bestCount = attempts.get(key);
                bestOffset = key;
            }
        }

        return decrypt(message, bestOffset) + " (Offset: " + bestOffset + ")";
    }

    /**
     * Counts the number of words in a given message that are present in a given dictionary.
     *
     * @param message The message to be searched for words.
     * @return The number of words in the message that are present in the dictionary.
     */
    public int countWords(String message){
        int words = 0;
        for(String s : getAsWordList(message)){
            if(dictionary.contains(s)){
                words++;
            }
        }
        return words;
    }
    /**
     * Extracts all words from a given message and returns them as a list.
     *
     * @param message The message to be searched for words.
     * @return A list of all words found in the message.
     */
    public List<String> getAsWordList(String message){
        Pattern pattern = Pattern.compile("\\b[A-Za-z]+\\b");
        List<String> words = new ArrayList<>();
        Matcher matcher = pattern.matcher(message);
        while(matcher.find()){
            String currentWord = matcher.group().toLowerCase();
            words.add(currentWord);
        }
        return words;
    }

}
