package main;

import entities.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    public static void main(String[] args) {

        List<Member> members = new ArrayList<>();

        //Member p1 = new Member();
        members.add(new Member("John", "Miller"));
        members.add(new Member("Sarah", "Thompson"));
        members.add(new Member("Michael", "Carter"));
        members.add(new Member("Emily", "Wilson"));
        members.add(new Member("David", "Anderson"));
        members.add(new Member("Laura", "Bennett"));
        members.add(new Member("Daniel", "Harris"));
        members.add(new Member("Emma", "Collins"));
        members.add(new Member("Robert", "Turner"));
        members.add(new Member("Olivia", "Parker"));

        int option = 0;

        try (Scanner scanner = new Scanner(System.in)) {
            while (option != 7) {

                System.out.println("\n1. Add a new book");
                System.out.println("2. Register a library member");
                System.out.println("3. Borrow a book");
                System.out.println("4. Return a book");
                System.out.println("5. View all available books");
                System.out.println("6. View all members");
                System.out.println("7. Exit");

                System.out.print("Enter option: ");
                option = scanner.nextInt();

                switch (option) {
                    case 1 ->
                        System.out.println("\nAdd a new book");

                    case 2 ->
                        System.out.println("\nRegister a library member");

                    case 3 ->
                        System.out.println("\nBorrow a book");

                    case 4 ->
                        System.out.println("\nReturn a book");

                    case 5 -> {
                        //System.out.println("\nView all available books");
                        System.out.println("\nView all members.");
                        for (Member n : members) {
                            System.out.println(n.getMemberId() + " " + n.getMemberName());
                        }
                    }

                    case 6 -> {
                        System.out.println("\nView all members.");
                        for (Member n : members) {
                            System.out.println(n);
                        }
                    }

                    case 7 ->
                        System.out.println("\nExiting program...");

                    default ->
                        System.out.println("\nInvalid option");
                }

            }
        }

    }
}
