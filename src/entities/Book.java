package entities;

public class Book {

   protected String bookName;
   protected String author;
   private int bookId;
   private int yearPublished;
   private boolean borrowed;
   // private int quantity;

   public Book(String bookName, String author, int bookId, int yearPublished, boolean isBorrowed) {
      this.bookName = bookName;
      this.author = author;
      this.bookId = bookId;
      this.yearPublished = yearPublished;
      this.borrowed = false;
   }

   // ---Getters
   public String getBookName() {
      return bookName;
   }

   public int getBookId() {
      return bookId;
   }

   public boolean isBorrowed() {
      return borrowed;
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

   public void setBookId(int bookId) {
      this.bookId = bookId;
   }

   public void setYearPublished(int yearPublished) {
      this.yearPublished = yearPublished;
   }

   // ---Methods

   public void borrowBook() {
      this.borrowed = true;
   }

   public void returnBook() {
      this.borrowed = false;
   }
}