package Assignment15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Management System Menu:");
            System.out.println("1. Borrow a book");
            System.out.println("2. Return a book");
            System.out.println("3. Search for a book");
            System.out.println("4. Create a book");
            System.out.println("5. Delete a book");
            System.out.println("6. Create a patron");
            System.out.println("7. Delete a patron");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    borrowBook(library, scanner);
                    break;
                case 2:
                    returnBook(library, scanner);
                    break;
                case 3:
                    searchForBook(library, scanner);
                    break;
                case 4:
                    createBook(library, scanner);
                    break;
                case 5:
                    deleteBook(library, scanner);
                    break;
                case 6:
                    createPatron(library, scanner);
                    break;
                case 7:
                    deletePatron(library, scanner);
                    break;
                case 8:
                    System.out.println("Exiting the library system.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createBook(Library library, Scanner scanner) {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();

        library.createBook(bookId, title, author);
        System.out.println("Book created successfully.");
    }

    private static void deleteBook(Library library, Scanner scanner) {
        System.out.print("Enter book ID to delete: ");
        int bookId = scanner.nextInt();

        if (library.deleteBook(bookId)) {
            System.out.println("Book deleted successfully.");
        } else {
            System.out.println("Book not found or is currently borrowed.");
        }
    }

    private static void createPatron(Library library, Scanner scanner) {
        System.out.print("Enter patron ID: ");
        int patronId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter patron name: ");
        String name = scanner.nextLine();

        library.createPatron(patronId, name);
        System.out.println("Patron created successfully.");
    }

    private static void deletePatron(Library library, Scanner scanner) {
        System.out.print("Enter patron ID to delete: ");
        int patronId = scanner.nextInt();

        if (library.deletePatron(patronId)) {
            System.out.println("Patron deleted successfully.");
        } else {
            System.out.println("Patron not found or has borrowed books.");
        }
    }


    private static void borrowBook(Library library, Scanner scanner) {
        System.out.print("Enter your patron ID: ");
        int patronId = scanner.nextInt();
        Patron patron = library.findPatron(patronId);

        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.print("Enter the book ID to borrow: ");
        int bookId = scanner.nextInt();
        Book book = library.findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        patron.borrowBook(book);
        System.out.println("Book borrowed successfully.");
    }

    private static void returnBook(Library library, Scanner scanner) {
        System.out.print("Enter your patron ID: ");
        int patronId = scanner.nextInt();
        Patron patron = library.findPatron(patronId);

        if (patron == null) {
            System.out.println("Patron not found.");
            return;
        }

        System.out.print("Enter the book ID to return: ");
        int bookId = scanner.nextInt();
        Book book = library.findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        patron.returnBook(book);
        System.out.println("Book returned successfully.");
    }

    private static void searchForBook(Library library, Scanner scanner) {
        System.out.print("Enter the book ID to search for: ");
        int bookId = scanner.nextInt();
        Book book = library.findBook(bookId);

        if (book == null) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}
