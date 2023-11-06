public class Player {
    private String playerName;
    private char symbol;

    public Player() {
        playerName = "P";
        symbol = 'X';
    }
    public Player(String playerName,char symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
    }

    public String getPlayerName() {
        return playerName;
    }

    public char getSymbol() {
        return symbol;
    }

    public char readCell (Board board, int row, int col) {
        return board.getCell(row, col);
    }

    public void setMove (Board board, Player currentPlayer, int row, int col) {
        //if (board.getCell(row,col) == board.EMPTY) {
            board.setCell(currentPlayer, row, col);
        //}
    }
}