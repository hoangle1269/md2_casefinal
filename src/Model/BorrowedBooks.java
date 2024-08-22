package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BorrowedBooks {
    private static BorrowedBooks instance;
    private static final String FILE_NAME = "BorrowedBooks.csv";
    private List<BorrowedBook> borrowedBooks;

    public BorrowedBooks() {
        this.borrowedBooks = loadBorrowedBooks();
    }

    public static BorrowedBooks getInstance() {
        if (instance == null) {
            instance = new BorrowedBooks();
        }
        return instance;
    }

    private List<BorrowedBook> loadBorrowedBooks() {
        List<BorrowedBook> borrowedBookList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                borrowedBookList.add(BorrowedBook.fromCSV(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return borrowedBookList;
    }

    public void saveBorrowedBooks() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (BorrowedBook borrowedBook : borrowedBooks) {
                bw.write(borrowedBook.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBorrowedBook(BorrowedBook borrowedBook) {
        borrowedBooks.add(borrowedBook);
        saveBorrowedBooks();
    }

    public void removeBorrowedBook(String studentId, String bookISBN) {
        borrowedBooks.removeIf(borrowedBook ->
                borrowedBook.getStudentId().equals(studentId) && borrowedBook.getBookISBN().equals(bookISBN));
        saveBorrowedBooks();
    }

    public List<BorrowedBook> getBorrowedBooks() {
        return borrowedBooks;
    }
}
