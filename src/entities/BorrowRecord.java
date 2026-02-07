package entities;

import java.time.LocalDate;

public class BorrowRecord {

    private static int counter = 1;
    private final int recordId;
    private final int memberId;
    private final String bookId;
    private final LocalDate borrowDate;
    private final LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowRecord(String bookId, int memberId) {
        this.recordId = counter++;
        this.memberId = memberId;
        this.bookId = bookId;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusWeeks(2);
    }

    // ---Getters
    public int getMemberId() {
        return memberId;
    }

    public String getBookId() {
        return bookId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    // ---methods
    public void returnBook() {
        this.returnDate = LocalDate.now();
    }

    public boolean isReturned() {
        return returnDate != null;
    }

}
