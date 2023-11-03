public class AiEngine {

    private String playerName;
    private char symbol;

    private boolean ai;

    public AiEngine(String playerName,char symbol, Boolean ai) {
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


    public char[] goForWin(Board board, AiEngine aiPlay) {
        boolean winnable = false;
        char[] winPos = new char[2];
        //searching for winnable row
        while ()
            for (int col = 0; col < board.LENGTH; col++) {
                for (int )
                if (board.getCell(row,0) == aiPlay.symbol || board.getCell(row, 1) == aiPlay.symbol
                        || board.getCell(row, 2) == aiPlay.symbol) {

                    board.getCell(row,col);
                    break;


                }
                for (int col = 0; col < board.LENGTH; col++) {




                if (board.getCasilla() = VACIA o ESTA LLENA o de que jugador es);
                matrix[i][j]*/
            }
        }
    }



    public boolean blockPlayer(Board board, Player player) {

    }


    public void chooseCenter(Board board) {

    }

    public void randomMove() {

    }
}
