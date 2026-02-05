package adapters;

import entities.*;
import java.util.List;

public interface LibraryRepository {
    Book findBookById(int bookId);
    Member findMemberById(int memberId);
    void addBook(Book book);
    void addMember(Member member);
    List<Book> getAllBooks();
    //BorrowRecord getBorrowRecordById(int recordId);
    void addBorrowRecord(BorrowRecord record);
}