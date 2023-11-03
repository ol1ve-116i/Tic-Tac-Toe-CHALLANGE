import java.util.Scanner;
public class Main1 {
    public static void main(String[] args) {

        int gameOpt, charOpt, charOpt2;

        boolean gameOp;

        String p1, p2;

        char player1Symbol[] = {'X', 'O'};
        char player2Symbol[] = {'X', 'O'};

        Scanner input = new Scanner(System.in);

        System.out.println("***Welcome to TIC-TAC-TOE the game!***");
        System.out.println();
        System.out.println("Select a option (type the number of the option)");
        System.out.println();
        System.out.println("(1) | 1 Player mode (vs AI)");
        System.out.println("(2) | 2 Player mode");

        gameOpt = input.nextInt();

         if (gameOpt == 1) {
                gameOp = true;
            } else {
                gameOp = false;
            }

        System.out.println("Enter the name of the first player");
        p1 = input.next();

        if (gameOp) {
            p2 = "AI";
        } else {
            System.out.println("Now enter the name of the second player");
            p2 = input.next();
        }

        System.out.println("Select the symbol for " + p1 + " (The second player will have " +
                "the opposite symbol (type the number of the option to select the symbol))");

        System.out.println("(1) | X");
        System.out.println("(2) | O");

        charOpt = input.nextInt();

        if (charOpt == 1) {
            charOpt = 0;
            charOpt2 = 1;
        } else {
            charOpt = 1;
            charOpt2 = 0;
        }

        Player player1 = new Player(p1, player1Symbol[charOpt], gameOp);
        Player player2 = new Player(p2, player2Symbol[charOpt2], gameOp);

        player1.getPlayerName();
        player2.getPlayerName();

       System.out.println(player1.getPlayerName() + ", whit the symbol " + player1Symbol[charOpt] + " is the player one, and "
                + player2.getPlayerName() + ", whit the symbol " + player2Symbol[charOpt2] + " is the player two");











        //turnos
        //private String getCurrentPlayer() {
        //  if (currentPlayer == p1) {
        //    currentPlayer = p2;
        //} else {
        //  currentPlayer = p1;
        //}
        //return currentPlayer;
        //}
    }
}
