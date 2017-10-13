import java.util.ArrayList;

public class King extends Piece {

    public King(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "K";
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return algebraicName();
        } else {
            return "k";
        }
    }

    @Override
    public Square[] movesFrom(Square square) {

        ArrayList<Square> squares = new ArrayList<>();

        char startFile = square.file;
        char startRank = square.rank;

        char currentFile;
        char currentRank;

        //DOWN
        currentFile = startFile;
        currentRank = (char) (startRank - 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        //UP
        currentFile = startFile;
        currentRank = (char) (startRank + 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        //LEFT
        currentFile = (char) (startFile - 1);
        currentRank = startRank;
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        //RIGHT
        currentFile = (char) (startFile + 1);
        currentRank = startRank;
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        //NORTHEAST
        currentFile = (char) (startFile + 1);
        currentRank = (char) (startRank + 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        //SOUTHWEST
        currentFile = (char) (startFile - 1);
        currentRank = (char) (startRank - 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        //SOUTHEAST
        currentFile = (char) (startFile + 1);
        currentRank = (char) (startRank - 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        //NORTHWEST
        currentFile = (char) (startFile - 1);
        currentRank = (char) (startRank + 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        return squares.toArray(new Square[squares.size()]);

    }
}
