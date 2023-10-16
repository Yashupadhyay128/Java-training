package Assignment15;

import java.util.ArrayList;
import java.util.List;
class Library {
    private List<Book> books;
    private List<Patron> patrons;

    public Library() {
        this.books = new ArrayList<>();
        this.patrons = new ArrayList<>();
    }

    public void createBook(int bookId, String title, String author) {
        Book newBook = new Book(bookId, title, author);
        books.add(newBook);
    }

    public boolean deleteBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null && book.isAvailable()) {
            books.remove(book);
            return true;
        }
        return false;
    }

    public void createPatron(int patronId, String name) {
        Patron newPatron = new Patron(patronId, name);
        patrons.add(newPatron);
    }

    public boolean deletePatron(int patronId) {
        Patron patron = findPatron(patronId);
        if (patron != null && patron.getBorrowedBooks().isEmpty()) {
            patrons.remove(patron);
            return true;
        }
        return false;
    }

    public Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    public Patron findPatron(int patronId) {
        for (Patron patron : patrons) {
            if (patron.getPatronId() == patronId) {
                return patron;
            }
        }
        return null;
    }
}
