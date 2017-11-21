import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ChessGame {

    List<Move> moves;

    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    public Move getMove(int n) {
        return moves.get(n-1);
    }

    //this actually just makes things more confusing IMO
    public List<Move> filter(Predicate<Move> filter) {
        return moves.stream().filter(filter).collect(Collectors.toList());
    }

    //filter done with a lambda
    public List<Move> getMovesWithComments() {
        return moves
                .stream()
                .filter(
                        move -> move.getBlackPly().getComment().isPresent() ||
                                move.getWhitePly().getComment().isPresent()
                ).collect(Collectors.toList());
    }

    //filter done with an anonymous inner class
    public List<Move> getMovesWithoutComments() {
        return moves
                .stream()
                .filter(new Predicate<Move>() {
                    @Override
                    public boolean test(Move move) {
                        return !move.getBlackPly().getComment().isPresent() &&
                                !move.getWhitePly().getComment().isPresent();
                    }
                }).collect(Collectors.toList());
    }

    //filter done using inner class PieceCheckPredicate, which implements Predicate<Move>
    public List<Move> getMovesWithPiece(Piece p) {
        return moves
                .stream()
                .filter(new PieceCheckPredicate(p))
                .collect(Collectors.toList());
    }

    class PieceCheckPredicate implements Predicate<Move> {

        private Piece p;

        PieceCheckPredicate(Piece p) {
            this.p = p;
        }

        @Override
        public boolean test(Move move) {
            return move.getWhitePly().getPiece().equals(p) ||
                    move.getBlackPly().getPiece().equals(p);
        }
    }

    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < moves.size(); i++) {
            sb.append("Move ");
            sb.append(i);
            sb.append(":\t");
            sb.append(moves.get(i));
            sb.append("\n");
        }

        return sb.toString();
    }
}
