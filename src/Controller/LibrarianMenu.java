package Controller;

import Model.Books;
import Model.BorrowedBooks;
import Model.BorrowedBook;
import Model.Students;
import Model.Student;
import Model.Book;

import java.util.List;
import java.util.Scanner;

public class LibrarianMenu implements Constants {
    private static Books books = Books.getInstance();
    private static BorrowedBooks borrowedBooks = BorrowedBooks.getInstance();
    private static Students students = Students.getInstance();

    public static void display() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Librarian Menu");
            System.out.println(LIBRARIAN_MENU_SHOW_ALL_BOOKS + ". Show All Books");
            System.out.println(LIBRARIAN_MENU_ADD_BOOKS + ". Add Books");
            System.out.println(LIBRARIAN_MENU_DELETE_BOOKS + ". Delete Books");
            System.out.println(LIBRARIAN_MENU_UPDATE_BOOKS + ". Update Books");
            System.out.println(LIBRARIAN_MENU_LIST_STUDENTS_BORROWING + ". Show List of Students Borrowing Books");
            System.out.println(LIBRARIAN_MENU_BACK_TO_MAIN + ". Back to Main Menu");
            System.out.print("Choose an option: ");

            try {
                int choice = scanner.nextInt();
                switch (choice) {
                    case LIBRARIAN_MENU_SHOW_ALL_BOOKS:
                        showAllBooks();
                        break;
                    case LIBRARIAN_MENU_ADD_BOOKS:
                        addBooks(scanner);
                        break;
                    case LIBRARIAN_MENU_DELETE_BOOKS:
                        deleteBooks(scanner);
                        break;
                    case LIBRARIAN_MENU_UPDATE_BOOKS:
                        updateBooks(scanner);
                        break;
                    case LIBRARIAN_MENU_LIST_STUDENTS_BORROWING:
                        listStudentsBorrowing();
                        break;
                    case LIBRARIAN_MENU_BACK_TO_MAIN:
                        return;
                    default:
                        System.out.println("Invalid choice, please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static void showAllBooks() {
        for (Book book : books.getBooks()) {
            System.out.println(book);
        }
    }

    private static void addBooks(Scanner scanner) {
        System.out.print("Enter ISBN: ");
        String ISBN = scanner.next();
        System.out.print("Enter Book Name: ");
        String name = scanner.next();
        System.out.print("Enter Author: ");
        String author = scanner.next();
        System.out.print("Enter Number of Copies: ");
        int numberOfCopies = scanner.nextInt();

        Book book = new Book(ISBN, name, author, numberOfCopies);
        books.addBook(book);
        System.out.println("Book added successfully.");
    }

    private static void deleteBooks(Scanner scanner) {
        System.out.print("Enter ISBN of the book to delete: ");
        String ISBN = scanner.next();
        books.removeBook(ISBN);
        System.out.println("Book deleted successfully.");
    }

    private static void updateBooks(Scanner scanner) {
        System.out.print("Enter ISBN of the book to update: ");
        String ISBN = scanner.next();
        Book book = books.getBookByISBN(ISBN);
        if (book != null) {
            System.out.print("Enter new Book Name: ");
            String name = scanner.next();
            System.out.print("Enter new Author: ");
            String author = scanner.next();
            System.out.print("Enter new Number of Copies: ");
            int numberOfCopies = scanner.nextInt();
            book.setNumberOfCopies(numberOfCopies);
            books.updateBook(book);
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    private static void listStudentsBorrowing() {
        List<BorrowedBook> borrowedBooksList = borrowedBooks.getBorrowedBooks();
        for (BorrowedBook borrowedBook : borrowedBooksList) {
            String studentId = borrowedBook.getStudentId();
            Student student = students.getStudentById(studentId);
            Book book = books.getBookByISBN(borrowedBook.getBookISBN());
            if (student != null && book != null) {
                System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() +
                        ", Borrowed Book: " + book.getName() + ", ISBN: " + book.getISBN());
            }
        }
    }
}
