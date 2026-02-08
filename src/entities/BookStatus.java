package entities;

public enum BookStatus {
    AVAILABLE,
    BORROWED;

    public boolean isAvailable() {
        return this == AVAILABLE;
    }
}
