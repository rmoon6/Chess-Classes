public class Square {

    char file;
    char rank;

    public Square(char file, char rank) {
        this.file = file;
        this.rank = rank;
    }

    public Square(String name) {
        this.file = name.charAt(0);
        this.rank = name.charAt(1);
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

}
