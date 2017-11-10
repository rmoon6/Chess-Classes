import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ChessGameTester {
    public static void main(String[] args) {
        List<Move> moves = generateMoves();
        ChessGame chessGame = new ChessGame(moves);

        System.out.println("Testing the getMoves() method from ChessGame. Should print all 6 moves:");
        printListOfMoves(chessGame.getMoves());

        System.out.println();

        System.out.println("<getMove> Should print move m2 defined below:");
        System.out.println(chessGame.getMove(2));

        System.out.println();

        System.out.println("<getMovesWithComment()> Should print m1, m3, m5, and m6:");
        printListOfMoves(chessGame.getMovesWithComments());

        System.out.println();

        System.out.println("<getMovesWithoutComment()> Should print m2 and m4:");
        printListOfMoves(chessGame.getMovesWithoutComments());

        System.out.println();

        System.out.println("<getMovesWithPiece()> Should print m6:");
        printListOfMoves(chessGame.getMovesWithPiece(new Rook(Color.WHITE)));

    }

    public static void printListOfMoves(List<Move> moves) {
        for (Move m : moves) {
            System.out.println(m);
        }
    }

    //I'll make this move every piece
    public static List<Move> generateMoves() {

        Move m1 = new Move(
                new Ply(
                        new Pawn(Color.WHITE),
                        new Square("a2"),
                        new Square("a4"),
                        Optional.ofNullable("This is a comment")
                ),
                new Ply(
                        new Rook(Color.BLACK),
                        new Square("h8"),
                        new Square("h1"),
                        Optional.ofNullable("This is a comment")
                )
        );

        Move m2 = new Move(
                new Ply(
                        new King(Color.WHITE),
                        new Square("e1"),
                        new Square("e2"),
                        Optional.ofNullable(null)
                ),
                new Ply(
                        new Knight(Color.BLACK),
                        new Square("h7"),
                        new Square("h5"),
                        Optional.ofNullable(null)
                )
        );

        Move m3 = new Move(
                new Ply(
                        new Queen(Color.WHITE),
                        new Square("a2"),
                        new Square("a4"),
                        Optional.ofNullable("This is a comment")
                ),
                new Ply(
                        new Bishop(Color.BLACK),
                        new Square("h7"),
                        new Square("h5"),
                        Optional.ofNullable("This is a comment")
                )
        );

        Move m4 = new Move(
                new Ply(
                        new Bishop(Color.WHITE),
                        new Square("a2"),
                        new Square("a4"),
                        Optional.ofNullable(null)
                ),
                new Ply(
                        new Queen(Color.BLACK),
                        new Square("h7"),
                        new Square("h5"),
                        Optional.ofNullable(null)
                )
        );

        Move m5 = new Move(
                new Ply(
                        new Knight(Color.WHITE),
                        new Square("a2"),
                        new Square("a4"),
                        Optional.ofNullable("This is a comment")
                ),
                new Ply(
                        new King(Color.BLACK),
                        new Square("h7"),
                        new Square("h5"),
                        Optional.ofNullable("This is a comment")
                )
        );

        Move m6 = new Move(
                new Ply(
                        new Rook(Color.WHITE),
                        new Square("a2"),
                        new Square("a4"),
                        Optional.ofNullable("this is a comment")
                ),
                new Ply(
                        new Pawn(Color.BLACK),
                        new Square("h7"),
                        new Square("h5"),
                        Optional.ofNullable(null)
                )
        );

        ArrayList<Move> moves = new ArrayList<>();
        moves.add(m1);
        moves.add(m2);
        moves.add(m3);
        moves.add(m4);
        moves.add(m5);
        moves.add(m6);

        return moves;

    }
}
