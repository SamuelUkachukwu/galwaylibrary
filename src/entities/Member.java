package entities;

import java.time.LocalDate;

public class Member {

    private static int counter = 1;
    private final int memberId;
    private final String firstName;
    private final String lastName;
    private final LocalDate dateCreated;
    private final int borrowLimit = 3;

    public Member(String firstName, String lastName) {
        this.memberId = counter++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateCreated = LocalDate.now();
    }

    // ---Getters
    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return firstName + " " + lastName;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    // ---toString method
    @Override
    public String toString() {
        return "Member ID: " + memberId
                + ", Name: " + firstName + " " + lastName
                + ", Date Joined: " + dateCreated;
    }

}
