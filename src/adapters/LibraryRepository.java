package adapters;

import entities.*;
import java.util.List;

public interface LibraryRepository {

    Book findBookById(String bookId);

    Member findMemberById(int memberId);

    void addBook(Book book);

    void addMember(Member member);

    List<Book> getAllBooks();

    void addBorrowRecord(BorrowRecord record);

    List<BorrowRecord> getBorrowRecords();

    void showBooksInMemberPossession(int memberId, List<BorrowRecord> records);
}
