package frameworks;

import adapters.LibraryRepository;
import entities.Book;
import entities.BorrowRecord;
import entities.Member;
import java.util.ArrayList;
import java.util.List;

public class InMemoryLibraryRepository implements LibraryRepository {

    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();
    private final List<BorrowRecord> borrowRecords = new ArrayList<>();

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getBookId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    // ---Members
    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    @Override
    public List<Member> getAllMembers() {
        return members;
    }

    // ---Record
    @Override
    public void addBorrowRecord(BorrowRecord record) {
        borrowRecords.add(record);
    }

    @Override
    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    @Override
    public void showBooksInMemberPossession(int memberId, List<BorrowRecord> records) {
        boolean found = false;

        for (BorrowRecord r : records) {
            if (r.getMemberId() == memberId && !r.isReturned()) {
                System.out.println("Book ID: " + r.getBookId());
                found = true;
            }
        }

        if (!found) {
            System.out.println("Library Member: " + memberId + " has no books in possession");
        }
    }

    @Override
    public long countBooksBorrowedByMember(int memberId) {
        long count = 0;

        for (BorrowRecord r : borrowRecords) {
            if (r.getMemberId() == memberId && !r.isReturned()) {
                count++;
            }
        }

        return count;
    }

}
