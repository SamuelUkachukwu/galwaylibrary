package entities;

public class Book {

   protected String bookName;
   protected String author;
   private final int bookId;
   private final int yearPublished;
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

   public void borrowBook() {
      this.borrowed = true;
   }

   public void returnBook() {
      this.borrowed = false;
   }
}