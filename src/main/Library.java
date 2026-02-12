package main;

import adapters.LibraryRepository;
import entities.Book;
import entities.Member;
import frameworks.InMemoryLibraryRepository;
import usecases.BorrowBookUseCase;
import usecases.ReturnBookUseCase;
import usecases.SearchBookUseCase;

import java.util.Scanner;

public class Library {

    private static void testData(LibraryRepository repo) {
        repo.addMember(new Member("John", "Miller"));
        repo.addMember(new Member("Sarah", "Thompson"));
        repo.addMember(new Member("Michael", "Carter"));
        repo.addMember(new Member("Emily", "Wilson"));
        repo.addMember(new Member("David", "Anderson"));

        repo.addBook(new Book("ISBN001", "The Hobbit", "Tolkien", 1937));
        repo.addBook(new Book("ISBN002", "1984", "Orwell", 1949));
        repo.addBook(new Book("ISBN003", "Dune", "Herbert", 1965));
        repo.addBook(new Book("ISBN004", "Foundation", "Asimov", 1951));
        repo.addBook(new Book("ISBN005", "Dracula", "Stoker", 1897));
        repo.addBook(new Book("ISBN006", "Hamlet", "Shakespeare", 1603));
        repo.addBook(new Book("ISBN007", "The Stand", "King", 1978));
        repo.addBook(new Book("ISBN008", "The Alchemist", "Coelho", 1988));
        repo.addBook(new Book("ISBN009", "Sapiens", "Harari", 2011));
        repo.addBook(new Book("ISBN010", "The Martian", "Weir", 2014));
    }

    public static void main(String[] args) {

        LibraryRepository bookRepo = new InMemoryLibraryRepository();
        testData(bookRepo);

        BorrowBookUseCase borrowBookUseCase = new BorrowBookUseCase(bookRepo);
        ReturnBookUseCase returnBookUseCase = new ReturnBookUseCase(bookRepo);
        SearchBookUseCase searchBookUseCase = new SearchBookUseCase(bookRepo);

        int option = 0;

        try (Scanner scanner = new Scanner(System.in)) {

            while (option != 8) {

                System.out.println("\n1. Add a new book");
                System.out.println("2. Register a library member");
                System.out.println("3. Borrow a book");
                System.out.println("4. Return a book");
                System.out.println("5. View all available books");
                System.out.println("6. View all members");
                System.out.println("7. Search for a book");
                System.out.println("8. Exit");

                System.out.print("Enter option: ");
                option = scanner.nextInt();
                scanner.nextLine();

                switch (option) {

                    case 1: {
                        // ---Add book functionality
                        System.out.print("\nEnter book Id (ISBN): ");
                        String bookId = scanner.nextLine();

                        System.out.print("\nEnter name of the book: ");
                        String bookName = scanner.nextLine();

                        System.out.print("\nEnter name of the author: ");
                        String authorName = scanner.nextLine();

                        System.out.print("\nEnter publication year: ");
                        int publicationYear = scanner.nextInt();
                        scanner.nextLine();

                        Book book = new Book(bookId, bookName, authorName, publicationYear);
                        bookRepo.addBook(book);

                        System.out.println("Book added successfully!");
                        break;
                    }
                    case 2:
                        // ---Add member functionality
                        System.out.print("\nEnter first name: ");
                        String firstName = scanner.nextLine();

                        System.out.print("Enter last name: ");
                        String lastName = scanner.nextLine();

                        Member member = new Member(firstName, lastName);
                        bookRepo.addMember(member);

                        System.out.println("Member registered successfully!");
                        System.out.println(member);
                        break;

                    case 3: {
                        // ---Borrow a book functionality
                        System.out.print("\nEnter member ID: ");
                        int memberId = scanner.nextInt();

                        System.out.print("\nEnter book ID: ");
                        String bookId = scanner.next();

                        borrowBookUseCase.execute(memberId, bookId);
                        break;
                    }
                    case 4: {
                        // ---Return a Book functionality
                        System.out.print("\nEnter book ID: ");
                        String bookId = scanner.next();

                        returnBookUseCase.execute(bookId);
                        break;
                    }
                    case 5:
                        // --- List all Books functionality
                        System.out.println("\nList of all Books in Galway Library");
                        for (Book b : bookRepo.getAllBooks()) {
                            System.out.println(b);
                        }
                        break;

                    case 6:
                        // --- List all Members functionality
                        System.out.println("\nList of all members of Galway Library.");
                        for (Member m : bookRepo.getAllMembers()) {
                            System.out.println(m);
                        }
                        break;

                    case 7: {
                        // --- Seach for a book functionality
                        System.out.print("\nEnter book ID: ");
                         String bookId = scanner.next();
                        searchBookUseCase.searchById(bookId);
                        break;
                    }
                    case 8:
                        // ---Exit case
                        System.out.println("\nExiting program...");
                        break;

                    default:
                        System.out.println("\nInvalid option");
                }
            }
        }
    }
}
