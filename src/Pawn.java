import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Color color) {
        super(color);
    }

    @Override
    public String algebraicName() {
        return "";
    }

    @Override
    public String fenName() {
        return algebraicName();
    }

    @Override
    public Square[] movesFrom(Square square) {

        if (getColor() == Color.BLACK) {

            if (square.rank == '7') {
                return new Square[]{new Square(square.file, '6'), new Square(square.file, '5')};
            }

            if (Square.isInBounds(square.file, (char) (square.rank-1))) {
                return new Square[]{new Square(square.file, (char)(square.rank-1))};
            }

        } else if (getColor() == Color.WHITE) {

            if (square.rank == '2') {
                return new Square[]{new Square(square.file, '4'), new Square(square.file, '3')};
            }

            if (Square.isInBounds(square.file, (char) (square.rank+1))) {
                return new Square[]{new Square(square.file, (char)(square.rank+1))};
            }

        }

        return new Square[0];   //the code will never reach here, but the compiler will yell at me if I don't put it

    }
}
