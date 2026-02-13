package usecases;

import entities.Book;
import adapters.LibraryRepository;

public class SearchBookUseCase {
    private LibraryRepository libraryRepository;

    public SearchBookUseCase(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public Book searchById(String bookId) {
        return libraryRepository.findBookById(bookId);
    }
}
