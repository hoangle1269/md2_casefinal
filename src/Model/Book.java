package Model;

public class Book {
    private String ISBN;
    private String name;
    private String author;
    private int numberOfCopies;

    public Book(String ISBN, String name, String author, int numberOfCopies) {
        this.ISBN = ISBN;
        this.name = name;
        this.author = author;
        this.numberOfCopies = numberOfCopies;
    }

    public String getISBN() { return ISBN; }
    public String getName() { return name; }
    public String getAuthor() { return author; }
    public int getNumberOfCopies() { return numberOfCopies; }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    @Override
    public String toString() {
        return ISBN + "," + name + "," + author + "," + numberOfCopies;
    }

    public static Book fromCSV(String csv) {
        String[] parts = csv.split(",");
        return new Book(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]));
    }
}
