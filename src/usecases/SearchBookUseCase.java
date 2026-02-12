package usecases;

import entities.Book;
import adapters.LibraryRepository;

public class SearchBookUseCase {
    private LibraryRepository libraryRepository;

    public SearchBookUseCase(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void searchById(String bookId) {
        Book foundBook = libraryRepository.findBookById(bookId);

        if (foundBook != null) {
            System.out.println("Title: " + foundBook.getBookName()
                    + "Author: " + foundBook.getAuthor()
                    + "Year Published: " + foundBook.getYearPublished());
        } else {
            System.out.print("Book not found");
        }
    }
}
