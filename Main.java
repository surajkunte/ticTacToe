package tictactoe;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Suraj", "X");
        Player player2 = new Player("Souvik", "O");

        TicTacToe game = new TicTacToe(player1, player2);
        game.playGame();
    }
}
