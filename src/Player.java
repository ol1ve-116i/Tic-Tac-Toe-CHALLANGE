public class Player {
    private int shoot;
    private int p1;
    private int p2;
    private int currentPlayer = p1;

    private boolean gameOver = false;

    public Player(int shoot, int currentPlayer, int p1, int p2, boolean gameOver) {
        this.shoot = shoot;
        this.currentPlayer = currentPlayer;
        this.gameOver = gameOver;
        this.p1 = p1;
        this.p2 = p2;
    }

    public int getShoot() {

        return shoot;
    }

    private int getCurrentPlayer() {
        if (currentPlayer == p1) {
            currentPlayer = p2;
        } else {
            currentPlayer = p1;
        }
        return currentPlayer;
    }


}