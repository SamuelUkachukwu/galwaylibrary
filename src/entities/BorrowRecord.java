package entities;
import java.time.LocalDate;

public class BorrowRecord {

   private static int counter = 1;
   private final int recordId;
   private final int memberId;
   private final int bookId;
   private final LocalDate borrowDate;
   private LocalDate returnDate;
   private LocalDate dueDate;


   public BorrowRecord(int memberId, int bookId) {
      this.recordId = counter++;
      this.memberId = memberId;
      this.bookId = bookId;
      this.borrowDate = LocalDate.now();
      this.returnDate = null;
      this.dueDate = borrowDate.plusWeeks(2);
   }

   public void returnBook() {
      this.returnDate = LocalDate.now();
   }
}