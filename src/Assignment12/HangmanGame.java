package Assignment12;

import java.util.Scanner;
import java.util.Random;

public class HangmanGame {
    private static String[] words = {
            "naruto: It's an anime character that has fox inside of him.",
            "orange: It's a fruit same as name of a colour.",
            "techprescient: The organization's name you work for.",
            "java: The name of the language for which you doing assignments.",
            "intellij: Most commonly used IDE for java."
    };
    private static Random random = new Random();
    private static String wordToGuess;
    private static String hint;
    private static String currentWord;
    private static int maxAttempts = 6;
    private static int attemptsLeft;

    public static void main(String[] args) {
        selectRandomWord();
        initializeGame();

        while (attemptsLeft > 0 && !currentWord.equals(wordToGuess)) {
            displayHangman();
            displayHint();
            displayCurrentWord();
            char guess = getPlayerGuess();
            if (!updateCurrentWord(guess)) {
                attemptsLeft--;
            }
        }

        displayGameOutcome();
    }

    private static void selectRandomWord() {
        int index = random.nextInt(words.length);
        String[] wordHintPair = words[index].split(": ");
        wordToGuess = wordHintPair[0];
        hint = wordHintPair[1];
    }

    private static void initializeGame() {
        currentWord = new String(new char[wordToGuess.length()]).replace('\0', '-');
        attemptsLeft = maxAttempts;
    }

    private static void displayHangman() {
        System.out.println("Hangman - Attempts left: " + attemptsLeft);
    }

    private static void displayHint() {
        System.out.println("Hint: " + hint);
    }

    private static void displayCurrentWord() {
        System.out.println("Current Word: " + currentWord);
    }

    private static char getPlayerGuess() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Guess a letter: ");
        String input = scanner.nextLine().toLowerCase();
        if (input.length() == 1 && Character.isLetter(input.charAt(0))) {
            return input.charAt(0);
        } else {
            System.out.println("Invalid input. Please enter a single letter.");
            return getPlayerGuess();
        }
    }

    private static boolean updateCurrentWord(char guess) {
        boolean found = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                currentWord = currentWord.substring(0, i) + guess + currentWord.substring(i + 1);
                found = true;
            }
        }
        return found;
    }

    private static void displayGameOutcome() {
        if (currentWord.equals(wordToGuess)) {
            System.out.println("Congratulations! You've guessed the word: " + wordToGuess);
        } else {
            System.out.println("You ran out of attempts. The word was: " + wordToGuess);
        }
    }
}

