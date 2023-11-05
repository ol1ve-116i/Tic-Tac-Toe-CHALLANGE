public class Board {

    public static final int LENGTH = 3;

    public static final char EMPTY = ' ';
    private char[][] matrix = new char[LENGTH][LENGTH];

    public Board() {
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix.length; col++){
                matrix[row][col] = EMPTY;
            }
        }
    }

    public void printMatrix() {  //sirve para imprimir directamente, no necesita un sout en Main
        printHeader();
        for (int i = 0; i < matrix.length; i++){
            System.out.print((i + 1));
            for (int j = 0; j < matrix.length; j++){
                if (getCell(i,j) == EMPTY){
                    System.out.print(" ");
                }else{
                    System.out.print(getCell(i,j));
                }
                System.out.print(matrix[i][j]);
                if (j < 3) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if ( i < 2){
                System.out.println("---------------");
            }
        }
        System.out.println();
    }


    public char getCell(int row, int col){
        return matrix[row][col];
    }

    public void setCell (int row, int col, char playerSymbol){
        matrix[row][col] = playerSymbol;
    }


    void printHeader(){
        System.out.print(" ");
        for (int i = 0; i < LENGTH; i++){
            System.out.print(" " + (i + 1) + "   ");
        }
        System.out.println();
    }


    //public static boolean checkDraw(Board board){
    // is done by a condicional if (!checkWin(.....) && checkFull(....)) into the Main
    //}


    public boolean checkWin (Player currentPlayer) {
        boolean isWinner = false;
        char currentSymbol = currentPlayer.getSymbol();

        //check Row
        for (int row = 0; row < LENGTH; row++) {
            if (getCell(row,0) == currentSymbol
                    && getCell(row,1) == currentSymbol
                    && getCell(row,2) == currentSymbol)
            {
                isWinner = true;
            }
        }
        // check Col
        for (int col = 0; col < LENGTH; col++) {
            if (getCell(0,col) == currentSymbol
                    && getCell(1, col) == currentSymbol
                    && getCell(2, col) == currentSymbol)
            {
                isWinner = true;
            }
        }

        // check Diagonal
        if (getCell(0,0) == currentSymbol
                && getCell(1,1) == currentSymbol
                && getCell(2,2) == currentSymbol) {
            isWinner = true;
        }

        if (getCell(0,2) == currentSymbol
                && getCell(1,1) == currentSymbol
                && getCell(2,0) == currentSymbol) {
            isWinner = true;
        }


        return isWinner;
    }

    public boolean checkFull() {
        boolean isFull = false;
        int markedCells = 0;

        for (int row = 0; row < LENGTH; row++) {
            for (int col = 0; col < LENGTH; col++) {
                if (getCell(row,col) != EMPTY) {
                    markedCells = markedCells + 1;
                }
            }
        }
        return (markedCells == (LENGTH * LENGTH));
    }
}