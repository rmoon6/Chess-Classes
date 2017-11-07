public class Square {

    char file;
    char rank;

    public Square(char file, char rank) {
        this.file = file;
        this.rank = rank;
    }

    public Square(String name) {

        this(name.charAt(0), name.charAt(1));

    }

    public char getFile() {
        return file;
    }

    public char getRank() {
        return rank;
    }

    @Override
    public String toString() {
        return String.valueOf(file) + rank;
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Square)) {
            return false;
        }

        Square otherSquare = (Square) obj;

        return (otherSquare.file == this.file
                && otherSquare.rank == this.rank);
    }

    public static boolean isInBounds(char file, char rank) {

        boolean fileCheck = file >= 'a' && file <= 'h';
        boolean rankCheck = rank >= '1' && rank <= '8';

        return fileCheck && rankCheck;

    }

    public static boolean isInBounds(Square square) {
        return isInBounds(square.file, square.rank);
    }

}
