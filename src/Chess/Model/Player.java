package Chess.Model;

public class Player {
    // Variables that do not change:
    private int id;
    private String name;
    private int age;
    boolean isNull; // For nullPlayer

    // Variables that might change:
    private char color; // W for white, B for black
    private int score;
    private int rank;
    private boolean turn;

    // Getters:

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isNull() {
        return isNull;
    }

    public char getColor () {
        return color;
    }

    public int getScore() {
        return score;
    }

    public int getRank() {
        return rank;
    }

    public boolean canPlay() {
        return turn;
    }

    // Setters:

    // ID, name and age do not change

    public void addScore (int points) {
        score += points;
        // Must tell controller to update rank
    }

    public void resetScore () {
        score = 0;
        // Must tell controller to update rank
    }

    public void setColor (char c) {
        color = c;
    }

    public void setRank(int r) {
        rank = r;
    }

    public void changeTurn() {
        turn = !turn;
    }

    // Constructors:

    public Player(String name, int age, boolean isNull) {
        this.name = name;
        this.age = age;
        score = 0;
        this.isNull = isNull;
        // must tell controller to update rank
    }

    public boolean isBetterThan (Player p) { // maybe needed for sort
        if (this.score > p.score)
            return true;
        return false;
    }

    public static Player nullPlayer () {
        return new Player("", 0, true);
    }
}
