import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "R";
    }

    @Override
    public String fenName() {
        if (getColor() == Color.WHITE) {
            return algebraicName();
        } else {
            return "r";
        }
    }

    @Override
    public Square[] movesFrom(Square square) {

        ArrayList<Square> squares = new ArrayList<>();

        char startFile = square.file;
        char startRank = square.rank;

        char currentFile;
        char currentRank;

        //UP
        currentFile = startFile;
        currentRank = (char) (startRank - 1);
        while (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
            currentRank = (char) (currentRank - 1);
        }

        //DOWN
        currentFile = startFile;
        currentRank = (char) (startRank + 1);
        while (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
            currentRank = (char) (currentRank + 1);
        }

        //LEFT
        currentFile = (char) (startFile - 1);
        currentRank = startRank;
        while (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
            currentFile = (char) (currentFile - 1);
        }

        //RIGHT
        currentFile = (char) (startFile + 1);
        currentRank = startRank;
        while (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
            currentFile = (char) (currentFile + 1);
        }

        return squares.toArray(new Square[squares.size()]);

    }
}
