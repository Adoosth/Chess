package Chess.Model;

public class Game {
    private Board board;
    private Player[] players;
    private boolean started;

    // Getters:

    public boolean isStarted () {
        return started;
    }
    public Board getBoard () {
        return board;
    }

    public Player getPlayerByID (int id) {
        for (Player p : players) {
            if (p.getID() == id)
                return p;
        }
        return Player.nullPlayer();
    }

    public Player[] getAllPlayers() {
        return players;
    }

    // Setters:

    public void start() {
        started = true;
    }

    public void finish() {
        started = false;
    }

    // Constructors:

    public Game(Board board, Player[] players) {
        this.board = board;
        this.players = players;
        this.started = false;
    }
}
