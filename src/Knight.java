import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "N";
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return algebraicName();
        } else {
            return "n";
        }
    }

    @Override
    public Square[] movesFrom(Square square) {

        ArrayList<Square> squares = new ArrayList<>();

        char startFile = square.file;
        char startRank = square.rank;

        char currentFile;
        char currentRank;

        currentFile = (char) (startFile - 2);
        currentRank = (char) (startRank - 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        currentFile = (char) (startFile + 2);
        currentRank = (char) (startRank + 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        currentFile = (char) (startFile - 2);
        currentRank = (char) (startRank + 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        currentFile = (char) (startFile + 2);
        currentRank = (char) (startRank - 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        currentFile = (char) (startFile - 1);
        currentRank = (char) (startRank - 2);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        currentFile = (char) (startFile + 1);
        currentRank = (char) (startRank + 2);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        currentFile = (char) (startFile - 1);
        currentRank = (char) (startRank + 2);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        currentFile = (char) (startFile + 1);
        currentRank = (char) (startRank - 2);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        return (Square[]) squares.toArray();

    }
}
