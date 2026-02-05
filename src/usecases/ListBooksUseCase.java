package usecases;

import java.util.List;

import adapters.LibraryRepository;
import entities.Book;

public class ListBooksUseCase {
    private final LibraryRepository libraryRepository;

    public ListBooksUseCase (LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    public void execute(){
        List<Book> books = libraryRepository.getAllBooks();
        for(Book book : books){
            System.out.println(book);
        }
    }
}


