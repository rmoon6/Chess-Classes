public class Move {

    private Ply whitePly;
    private Ply blackPly;

    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }

    public Ply getWhitePly() {
        return whitePly;
    }

    public Ply getBlackPly() {
        return blackPly;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("White ply: ");
        sb.append(getWhitePly());
        sb.append("\t");
        sb.append("Black ply: ");
        sb.append(getBlackPly());

        return sb.toString();
    }
}
