package usecases;

import entities.Book;
import adapters.LibraryRepository;
import java.util.Optional;

public class SearchBookUsecase {
    private LibraryRepository libraryRepository;

    public SearchBookUsecase(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }


    public Optional<Book> searchBookById(String bookId) {
        return libraryRepository.findBookById(bookId);
    }
}
