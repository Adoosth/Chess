package Chess.Model;

public class Square {
    private int row, col;
    private boolean isNull; // For nullSquare

    // Getters:

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    // Setters:

    public void setRow(int r) {
        row = r;
    }

    public void setCol(int c) {
        col = c;
    }

    public boolean isNull() {
        return isNull;
    }

    // Constructors:

    public Square(int r, int c) {
        row = r;
        col = c;
        isNull = false;
    }

    public Square(int r, int c, boolean b) {
        row = r;
        col = c;
        isNull = b;
    }

    // Class functions:

    public void copyFrom(Square src) {
        row = src.getRow();
        col = src.getCol();
        isNull = src.isNull();
    }

    public static boolean isEqual (Square a, Square b) {
        if (a.isNull() || b.isNull()) // We should never compare a nullSquare
            return false;
        if (a.getRow() == b.getRow() && a.getCol() == b.getCol())
            return true;
        return false;
    }

    public static Square nullSquare () {
        return new Square(-1, -1, true);
    }
}
