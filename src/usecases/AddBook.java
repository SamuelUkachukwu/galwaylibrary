package usecases;

import adapters.LibraryRepository;
import entities.Book;

public class AddBook {
    private final LibraryRepository libraryRepository;

    public AddBook(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void execute(Book book) {
        libraryRepository.addBook(book);
    }
}
