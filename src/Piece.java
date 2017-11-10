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
    public abstract Square[] movesFrom(Square square);

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof Piece)) {
            return false;
        }

        Piece p = (Piece) obj;

        return p.fenName().equals(this.fenName()) && this.getColor() == p.getColor();
    }

    @Override
    public String toString() {
        return this.fenName();
    }
}
