package entities;

public enum Status {
        AVAILABLE,
        BORROWED;

        public boolean isAvailable() {
            return this == AVAILABLE;
        }
}
