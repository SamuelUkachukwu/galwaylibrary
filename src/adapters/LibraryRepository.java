package adapters;

import entities.*;
import java.util.List;

public interface LibraryRepository {
    // ---Books
    void addBook(Book book);

    Book findBookById(String bookId);

    List<Book> getAllBooks();

    // ---Memebers
    void addMember(Member member);

    Member findMemberById(int memberId);

    List<Member> getAllMembers();

    // ---Records
    void addBorrowRecord(BorrowRecord record);

    List<BorrowRecord> getBorrowRecords();

    void showBooksInMemberPossession(int memberId, List<BorrowRecord> records);
}
