public class InvalidSquareException extends RuntimeException {

    private char file;
    private char rank;

    public InvalidSquareException(char file, char rank) {
        this.file = file;
        this.rank = rank;
    }

    @Override
    public String getMessage() {
        return String.valueOf(file) +
                rank;
    }
}
