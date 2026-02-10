package usecases;

import adapters.LibraryRepository;
import entities.Book;
import entities.BorrowRecord;

public class ReturnBookUseCase {
    private final LibraryRepository libraryRepository;

    public ReturnBookUseCase(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void execute(String bookId) {
        Book book = libraryRepository.findBookById(bookId);

        if (book == null) {
            System.out.println("The book with ID: " + bookId + " was not found");
            return;
        }

        if (book.isAvailable()) {
            System.out.println("Return failed | Book is already in the Library");
            return;
        }

        BorrowRecord record = libraryRepository.getBorrowRecords(bookId);

        if (record == null) {
            System.out.println("Return failed | No active borrow record");
        }

        record.returnBook();
        book.returnBook();
        System.out.println(
                "Book with ID: "
                        + bookId + " Title: " + "'"
                        + book.getBookName() + "'"
                        + " successfully returned.");

    }
}
