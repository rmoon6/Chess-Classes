import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "B";
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return algebraicName();
        } else {
            return "b";
        }
    }

    @Override
    public Square[] movesFrom(Square square) {

        ArrayList<Square> squares = new ArrayList<>();

        char startFile = square.file;
        char startRank = square.rank;

        char currentFile;
        char currentRank;

        //SOUTHEAST
        currentFile = (char) (startFile + 1);
        currentRank = (char) (startRank + 1);
        while (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
            currentFile = (char) (currentFile + 1);
            currentRank = (char) (currentRank + 1);
        }

        //NORTHWEST
        currentFile = (char) (startFile - 1);
        currentRank = (char) (startRank - 1);
        while (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
            currentFile = (char) (currentFile - 1);
            currentRank = (char) (currentRank - 1);
        }

        //NORTHEAST
        currentFile = (char) (startFile + 1);
        currentRank = (char) (startRank - 1);
        while (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
            currentFile = (char) (currentFile + 1);
            currentRank = (char) (currentRank - 1);
        }

        //SOUTHWEST
        currentFile = (char) (startFile - 1);
        currentRank = (char) (startRank + 1);
        while (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
            currentFile = (char) (currentFile - 1);
            currentRank = (char) (currentRank + 1);
        }

        return squares.toArray(new Square[squares.size()]);

    }
}
