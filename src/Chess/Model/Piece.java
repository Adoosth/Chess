package Chess.Model;

import java.util.ArrayList;

public class Piece {
    public enum Type {Null, King, Queen, Bishop, Knight, Castle, Pawn}; // Null type only for nullPiece
    private char color; // W for white, B for black, anything else for nullPiece
    private Type type; // 0 = Null, 1 = King, 2 = Queen, 3 = Bishop, 4 = Knight, 5 = Castle, 6 = Pawn
    private Square loc; // location
    private boolean isDead;

    private ArrayList<Square> goTo; // List of squares this piece can move to

    // Getters:

    public char getColor() {
        return color;
    }

    public Type getType(){
        return type;
    }

    public Square getLoc() {
        return loc; // our loc might be changed :|
    }

    public boolean isDead() {
        return isDead;
    }

    public boolean canGoTo (Square dst) {
        for (Square s : goTo) {
            if (Square.isEqual(s, dst))
                return true;
        }
        return false;
    }

    // Setters:

    // Colour never changes

    public void setType (Type t) { // When pawn reaches far side of board, type may change
        type = t;
    }

    public void moveTo(Square dst) {
        if (canGoTo(dst))
            loc = dst; // Not sure if we should create new Square and copy from dst
        //  Else, it should give an error :/
    }

    public void addGoTo(Square dst) {
        if (canGoTo(dst))
            return;
        goTo.add(dst);
    }

    public void resetGoTo() {
        goTo.clear();
    }

    public void Die() {
        isDead = true;
        loc = Square.nullSquare(); // means it's in the graveyard
        // Type does not change, it's a dead piece, not a nullPiece
    }

    // Constructors:

    public Piece(char c, Type t, Square l){
        color = c;
        type = t;
        loc = l;
        if (l.isNull()) {
            isDead = true;
        }
        else
            isDead = false;
    }

    // Class Functions:

    public static Piece nullPiece () {
        return new Piece('\0', Type.Null, Square.nullSquare());
    }

    public void copyFrom (Piece src)  {
        color = src.getColor();
        type = src.getType();
        loc = src.getLoc();
        isDead = src.isDead();
    }
}
