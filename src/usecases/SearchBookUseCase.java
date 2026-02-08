package usecases;

import entities.Book;
import adapters.LibraryRepository;
import java.util.Optional;

public class SearchBookUsecase {
    private LibraryRepository libraryRepository;

    public SearchBookUsecase(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public String searchById(String bookId) {
        Optional<Book> optionalBook = libraryRepository.findBookById(bookId);

        if(optionalBook.isPresent()) {
            Book book = optionalBook.get();

            return "Title: " + book.getBookName()
                + "Author: " + book.getAuthor()
                + "Year Published: " + book.yearPublished();
        } else {
            return "Book not found";
        }
    }

    // public Optional<Book> searchBookById(String bookId) {
    //     return libraryRepository.findBookById(bookId);
    // }
}
