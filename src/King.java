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

        //UP
        currentFile = startFile;
        currentRank = (char) (startRank - 1);
        if (Square.isInBounds(currentFile, currentRank)) {
            squares.add(new Square(currentFile, currentRank));
        }

        //DOWN
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

        return (Square[]) squares.toArray();

    }
}
