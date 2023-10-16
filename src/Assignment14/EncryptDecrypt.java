package Assignment14;

import java.util.Scanner;

public class EncryptDecrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Caesar Cipher Encryption and Decryption");
        System.out.print("Enter the text: ");
        String text = scanner.nextLine();
        System.out.print("Enter the shift (a positive integer): ");
        int shift = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Encrypt or Decrypt (E/D): ");
        char choice = scanner.nextLine().charAt(0);
        if (choice == 'E' || choice == 'e') {
            String encryptedText = encrypt(text, shift);
            System.out.println("Encrypted text: " + encryptedText);
        } else if (choice == 'D' || choice == 'd') {
            String decryptedText = decrypt(text, shift);
            System.out.println("Decrypted text: " + decryptedText);
        } else {
            System.out.println("Invalid choice. Please enter 'E' for encryption or 'D' for decryption.");
        }
        scanner.close();
    }

    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                result.append((char)((c - base + shift) % 26 + base));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }
}

