import java.util.HashSet;
import java.util.Set;

public class ChessTester {

    public static void main(String[] args) {

        System.out.println("Testing each piece from the corners of the board (bottom left, top left, bottom right, top right)");
        System.out.println("Pawn (WHITE):");
        Pawn p = new Pawn(Color.WHITE);
        printSquareArray(p.movesFrom(new Square('a', '1')));
        printSquareArray(p.movesFrom(new Square('a', '8')));
        printSquareArray(p.movesFrom(new Square('h', '1')));
        printSquareArray(p.movesFrom(new Square('h', '8')));
        System.out.println("Algebraic name: " + p.algebraicName());
        System.out.println("FEN name: " + p.fenName());
        System.out.println();

        System.out.println("Pawn (BLACK):");
        Pawn p2 = new Pawn(Color.BLACK);
        printSquareArray(p2.movesFrom(new Square('a', '1')));
        printSquareArray(p2.movesFrom(new Square('a', '8')));
        printSquareArray(p2.movesFrom(new Square('h', '1')));
        printSquareArray(p2.movesFrom(new Square('h', '8')));
        System.out.println("Algebraic name: " + p2.algebraicName());
        System.out.println("FEN name: " + p2.fenName());
        System.out.println();

        System.out.println("Rook:");
        Rook r = new Rook(Color.WHITE);
        printSquareArray(r.movesFrom(new Square('a', '1')));
        printSquareArray(r.movesFrom(new Square('a', '8')));
        printSquareArray(r.movesFrom(new Square('h', '1')));
        printSquareArray(r.movesFrom(new Square('h', '8')));
        System.out.println("Algebraic name: " + r.algebraicName());
        System.out.println("FEN name: " + r.fenName());
        System.out.println();

        System.out.println("Knight:");
        Knight n = new Knight(Color.WHITE);
        printSquareArray(n.movesFrom(new Square('a', '1')));
        printSquareArray(n.movesFrom(new Square('a', '8')));
        printSquareArray(n.movesFrom(new Square('h', '1')));
        printSquareArray(n.movesFrom(new Square('h', '8')));
        System.out.println("Algebraic name: " + n.algebraicName());
        System.out.println("FEN name: " + n.fenName());
        System.out.println();

        System.out.println("Bishop:");
        Bishop b = new Bishop(Color.WHITE);
        printSquareArray(b.movesFrom(new Square('a', '1')));
        printSquareArray(b.movesFrom(new Square('a', '8')));
        printSquareArray(b.movesFrom(new Square('h', '1')));
        printSquareArray(b.movesFrom(new Square('h', '8')));
        System.out.println("Algebraic name: " + b.algebraicName());
        System.out.println("FEN name: " + b.fenName());
        System.out.println();

        System.out.println("Queen:");
        Queen q = new Queen(Color.WHITE);
        printSquareArray(q.movesFrom(new Square('a', '1')));
        printSquareArray(q.movesFrom(new Square('a', '8')));
        printSquareArray(q.movesFrom(new Square('h', '1')));
        printSquareArray(q.movesFrom(new Square('h', '8')));
        System.out.println("Algebraic name: " + q.algebraicName());
        System.out.println("FEN name: " + q.fenName());
        System.out.println();

        System.out.println("King:");
        King k = new King(Color.WHITE);
        printSquareArray(k.movesFrom(new Square('a', '1')));
        printSquareArray(k.movesFrom(new Square('a', '8')));
        printSquareArray(k.movesFrom(new Square('h', '1')));
        printSquareArray(k.movesFrom(new Square('h', '8')));
        System.out.println("Algebraic name: " + k.algebraicName());
        System.out.println("FEN name: " + k.fenName());
        System.out.println();

        try {
            new Square("a1");
            System.out.println("worked");
        } catch (InvalidSquareException e) {
            System.out.println(e.getMessage());
        }

        //this doesn't really work anymore since the square class now allows squares to be invalid
        try {
            new Square("a9");
            System.out.println("worked");
        } catch (InvalidSquareException e) {
            System.out.println(e.getMessage());
        }

        Square s = new Square("f7");
        Square s2 = new Square('e', '4');
        System.out.println(s);
        System.out.println(s2);
    }

    public static void printSquareArray(Square[] squares) {

        if (squares.length == 0) {
            System.out.print("None");
        }

        for (Square s : squares) {
            System.out.print(s + "\t");
        }
        System.out.println();

    }

}
