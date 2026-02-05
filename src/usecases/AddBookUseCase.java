package usecases;

import adapters.LibraryRepository;
import entities.Book;

public class AddBookUseCase {
    private final LibraryRepository libraryRepository;

    public AddBookUseCase(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void execute(Book book) {
        libraryRepository.addBook(book);
    }
}