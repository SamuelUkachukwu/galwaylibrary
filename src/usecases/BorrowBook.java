package usecases;

import adapters.LibraryRepository;
import entities.*;

public class BorrowBook {
    private final LibraryRepository libraryRepository;

    public BorrowBook(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void execute(int memberId, int bookId) {
        Book book = libraryRepository.getBookById(bookId);
        Member member = libraryRepository.getMemberById(memberId);

        if (book == null || book.isBorrowed()) {
            book.setBorrowed(true);
            libraryRepository.updateBook(book);
            System.out.println("Book borrowed successfully. Book ID: " + book.getBookId());
        } else {
            System.out.println("Failed to borrow book.");
        }
    }
}
