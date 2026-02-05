package entities;

import java.time.LocalDate;

public class BorrowRecord {

   private static int counter = 1;
   private final int recordId;
   private final int memberId;
   private final String bookId;
   private final LocalDate borrowDate;
   private LocalDate dueDate;

   public BorrowRecord(String bookId, int memberId) {
      this.recordId = counter++;
      this.memberId = memberId;
      this.bookId = bookId;
      this.borrowDate = LocalDate.now();
      this.dueDate = borrowDate.plusWeeks(2);
   }

   public void returnBook() {
      //this.returnDate = LocalDate.now();
   }
}