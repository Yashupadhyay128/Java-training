package Assignment3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a text:");
        String inputText = scanner.nextLine();
        int wordCount = countWords(inputText);
        System.out.println("Number of words: " + wordCount);
        scanner.close();
    }

    public static int countWords(String text) {
        Pattern wordPattern = Pattern.compile("[\\p{Punct}\\s]+");
        String[] words = wordPattern.split(text);
        return words.length;
    }
}

