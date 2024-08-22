package Utils;

import Model.Book;
import Model.Books;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class BooksInitializer {
    public static void initializeBooks() {
        List<Book> initialBooks = Arrays.asList(
                new Book("ISBN001", "Harry Potter", "J.K Rowling", 70),
                new Book("ISBN002", "Narnia", "CS. Lewis", 60),
                new Book("ISBN003", "The Boys", "Eric Kripke", 40),
                new Book("ISBN004", "Sherlock Holmes", "Conan Doyle", 50),
                new Book("ISBN005", "LOTR", "JJ Tolkien", 90),
                new Book("ISBN006", "50 Shades", "E. L. James", 20),
                new Book("ISBN007", "TKKG", "Stefan Wolf", 45),
                new Book("ISBN008", "GOT", "George R. R. Martin", 80),
                new Book("ISBN009", "MCU", "Stan Lee", 67),
                new Book("ISBN010", "DC", "DC Comics", 89)
        );

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Books.csv"))) {
            for (Book book : initialBooks) {
                bw.write(book.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
