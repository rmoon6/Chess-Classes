public abstract class Piece {

    private Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract String algebraicName();
    public abstract String fenName();
    public abstract Square[] movesFrom(Square square);  //empty board => makes things easy; no castling or taking

}
