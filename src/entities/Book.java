package entities;

public class Book {

    protected String bookName;
    protected String author;
    private String bookId;
    private int yearPublished;
    private boolean available;
    // private int quantity;

    public Book(String bookId, String bookName, String author, int yearPublished, boolean isAvailable) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = true;
    }

    // ---Getters
    public String getBookName() {
        return bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    // ---Setters
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    // ---Methods
    public void borrowBook() {
        this.available = false;
    }

    public void returnBook() {
        this.available = true;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId
                + ", Title: " + bookName
                + ", Author: " + author
                + ", Year Published: " + yearPublished;
    }
}
