package frameworks;

import usecases.*;
import java.util.Scanner;
import entities.*;

public class ConsoleController {
    private final AddMember addMemberUseCase;
    private final AddBook addBookUseCase;
    private final BorrowBook borrowBookUseCase;

    public ConsoleController(AddMember addMemberUseCase, AddBook addBookUseCase, BorrowBook borrowBookUseCase) {
        this.addMemberUseCase = addMemberUseCase;
        this.addBookUseCase = addBookUseCase;
        this.borrowBookUseCase = borrowBookUseCase;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Galway City Library");
        
        while (true) {
            System.out.println("\n1. Add Member");
            System.out.println("2. Add Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. List Book");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    addMemberUseCase.execute(new Member(firstName, lastName));
                    System.out.println("Member added successfully.");
                }

                case 2 -> {
                    System.out.print("Enter book name: ");
                    String bookName = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter year published: ");
                    int yearPublished = scanner.nextInt();
                    addBookUseCase.execute(new Book(bookName, author, yearPublished));
                    System.out.println("Book added successfully.");
                }

                case 3 -> {
                    System.out.print("Enter member ID: ");
                    int memberId = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    borrowBookUseCase.execute(memberId, bookId);
                }

                case 4 -> {
                    System.out.println("Listing all books:");
                    for (Book book : addBookUseCase.libraryRepository.getAllBooks()) {
                        System.out.println("ID: " + book.getBookId() + ", Name: " + book.getBookName() + ", Author: " + book.getAuthor() + ", Year Published: " + book.getYearPublished() + ", Borrowed: " + book.getIsBorrowed());
                    }
                }

                case 5 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
            }
        }
    }
}
