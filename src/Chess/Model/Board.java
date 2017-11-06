package Chess.Model;

import java.util.ArrayList;

public class Board {
    private Piece[] pieces;

    // Getters:

    public Piece[] getAllPieces() {
        return pieces; // This could change pieces (not good)
    }

    public Piece getPieceBySquare(Square loc) {
        for (Piece p : pieces) {
            if (!p.isDead() && Square.isEqual(loc, p.getLoc()))
                return p; // At most 1 piece can be at each square
        }
        // If no piece was found at loc, return nullPiece
        return Piece.nullPiece();
    }

    public Piece[] getPiecesByColor (char color, boolean withDead) {
        ArrayList<Piece> arr = null;
        for (Piece p : pieces) {
            if (!withDead && p.isDead())
                continue;
            if (p.getColor() == color) 
                arr.add(p);
        }
        return (Piece[])arr.toArray();
    }

    // There are no setters for the board, only constructors:

    public Board (Board src) {
        this.copyFrom(src);
    }
    public Board (Piece[] ps) {
        pieces = ps;
        // Since board initial setup is for the controller,
        // we expect the pieces to be given to us initialized
    }

    // Class functions:

    public void copyFrom(Board src) {
        pieces = new Piece[src.pieces.length];
        for (int i = 0; i < src.pieces.length; i++) {
            pieces[i].copyFrom(src.pieces[i]);
        }
    }
}
