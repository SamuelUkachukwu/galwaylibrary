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
        Member member = libraryRepository.findMemberById(memberId);

        if (book != null && member != null && book.isAvailable()) {
            book.borrowBook();
            //book.setBookId(true);
            //libraryRepository.updateBook(book);
            libraryRepository.addBorrowRecord(new BorrowRecord(bookId, memberId));
            System.out.println("Book borrowed successfully. Book ID: " + book.getBookId());
        } else {
            System.out.println("Failed to borrow book.");
        }
    }
}
