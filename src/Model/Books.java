package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Books {
    private static Books instance;
    private static final String FILE_NAME = "Books.csv";
    private List<Book> books;

    private Books() {
        this.books = loadBooks();
    }

    public static Books getInstance() {
        if (instance == null) {
            instance = new Books();
        }
        return instance;
    }

    private List<Book> loadBooks() {
        List<Book> bookList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                bookList.add(Book.fromCSV(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    public void saveBooks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Book book : books) {
                bw.write(book.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void removeBook(String ISBN) {
        books.removeIf(book -> book.getISBN().equals(ISBN));
        saveBooks();
    }

    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN().equals(updatedBook.getISBN())) {
                books.set(i, updatedBook);
                break;
            }
        }
        saveBooks();
    }

    public Book getBookByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooks() {
        return books;
    }
}
