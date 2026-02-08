package entities;

public class Book {

    protected String bookName;
    protected String author;
    private String bookId;
    private int yearPublished;
    private BookStatus status;

    public Book(String bookId, String bookName, String author, int yearPublished) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
        this.status = BookStatus.AVAILABLE;
    }

    // ---Getters
    public String getBookName() {
        return bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return status == BookStatus.AVAILABLE;
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
        if (!isAvailable()) {
            throw new IllegalStateException("Book is out on loan");
        }
        this.status = BookStatus.BORROWED;
    }

    public void returnBook() {
        if (isAvailable()) {
            throw new IllegalStateException("Book is available");
        }
        this.status = BookStatus.AVAILABLE;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId
                + ", Title: " + bookName
                + ", Author: " + author
                + ", Year Published: " + yearPublished
                + ", Status: " + status;
    }
}
