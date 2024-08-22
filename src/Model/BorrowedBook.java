package Model;

public class BorrowedBook {
    private String studentId;
    private String bookISBN;

    public BorrowedBook(String studentId, String bookISBN) {
        this.studentId = studentId;
        this.bookISBN = bookISBN;
    }

    public String getStudentId() { return studentId; }
    public String getBookISBN() { return bookISBN; }

    @Override
    public String toString() {
        return studentId + "," + bookISBN;
    }

    public static BorrowedBook fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new BorrowedBook(parts[0], parts[1]);
    }
}
