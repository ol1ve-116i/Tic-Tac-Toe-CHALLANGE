public class Player {
    private String playerName;
    private char symbol;

    private boolean ai;

    public Player() {
        playerName = "P";
        symbol = 'X';
        ai = false;
    }
    public Player(String playerName,char symbol, Boolean ai) {
        this.playerName = playerName;
        this.symbol = symbol;
        this.ai = ai;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean isAi() {
        return ai;
    }
}