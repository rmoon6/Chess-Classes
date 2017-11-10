import java.util.Optional;

public class Ply {

    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;   //why are we using this deprecated nonsense?

    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }

    public Piece getPiece() {
        return piece;
    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }

    public Optional<String> getComment() {
        return comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Move: [ Piece: ");
        sb.append(getPiece());
        sb.append(",\tFrom Square: ");
        sb.append(getFrom());
        sb.append(",\tTo Square: ");
        sb.append(getTo());

        if (getComment().isPresent()) {
            sb.append(",\tComment: ");
            sb.append(getComment().get());
        } else {
            sb.append("There is no comment for this move");
        }

        sb.append(" ]");

        return sb.toString();
    }
}
