package usecases;

import adapters.LibraryRepository;
import entities.*;

public class BorrowBookUseCase {
    private final LibraryRepository libraryRepository;

    public BorrowBookUseCase(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void execute(int memberId, String bookId) {
        Book book = libraryRepository.findBookById(bookId);

        if (book == null) {
            System.out.println("Book with ID " + bookId + " not found");
            return;
        }

        Member member = libraryRepository.findMemberById(memberId);
        if (member == null) {
            System.out.println("Member with ID " + memberId + " not found");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println(book.getBookName() + " is already borrowed");
            return;
        }

        long borrowedBookCount = libraryRepository.countBooksBorrowedByMember(memberId);

        if (borrowedBookCount >= member.getBorrowLimit()) {
            System.out.println(member.getMemberName() + "'s borrow limit has been reached");
            return;
        }

        book.borrowBook();
        libraryRepository.addBorrowRecord(new BorrowRecord(bookId, memberId));

        System.out.println(
                "Book borrowed successfully to member \nID No: " + memberId + "\nName: " + member.getMemberName());
        // if (book != null && member != null && book.isAvailable()) {
        // book.borrowBook();
        // //book.setBookId(true);
        // //libraryRepository.updateBook(book);
        // libraryRepository.addBorrowRecord(new BorrowRecord(bookId, memberId));
        // System.out.println("Book borrowed successfully. Book ID: " +
        // book.getBookId());
        // } else {
        // System.out.println("Failed to borrow book.");
        // }
    }

}
