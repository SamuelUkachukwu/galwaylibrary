package frameworks;

import java.util.ArrayList;
import java.util.List;

import adapters.LibraryRepository;
import entities.Book;
import entities.BorrowRecord;
import entities.Member;

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
    public Member findMemberById(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }

    @Override
    public void addMember(Member member) {
        members.add(member);
    }

    @Override
    public List<Book> getAllBooks() {
        return books;
    }

    @Override
    public void addBorrowRecord(BorrowRecord record) {
        borrowRecords.add(record);
    }

    // @Override
    // public void updateBook(Book book) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'updateBook'");
    // }

}
