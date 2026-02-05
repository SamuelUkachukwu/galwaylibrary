package usecases;


import entities.Book;
import java.util.List;


public interface BookRepository {
   void add(Book book);
   Book findById(String id);
   List<Book> findAll();
}