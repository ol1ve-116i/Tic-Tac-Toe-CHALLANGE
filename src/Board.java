public class Board {

    public static final int LENGTH = 3;
    private char[][] matrix = new char[LENGTH][LENGTH];

    public Board() {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                matrix[i][j] = ' ';
            }
        }
    }


    public void printMatrix() {  //sirve para imprimir directamente, no necesita un sout en Main
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix.length; j++){
                System.out.print(matrix[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if ( i < 2){
                System.out.println("----------");
            }
        }
    }


    public char getCell(int row, int col){
        return matrix[row][col];
    }
    public void setCell(int row, int col){
        this.matrix = matrix[row][col];
    }


    static void printHeader(){
        System.out.println(" ");
        for (int i = 0; i <= LENGTH; i++){
            System.out.println(i + " ");
        }
        System.out.println();
    }
}
