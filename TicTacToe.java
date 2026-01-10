package tictactoe;

import java.util.Scanner;

public class TicTacToe implements game{
    Board board;
    Player player1;
    Player player2;
    Player currentPlayer;

    TicTacToe(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1;
        board = new Board();
    }

    boolean isValid(int row, int col){
        return (row >= 0 && row < 3 && col >= 0 && col < 3);
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while(true){
            board.printBoard();
            System.out.println("Turn: " + currentPlayer.name + "(" + currentPlayer.symbol + ")");

            int row, col;

            while (true) {
                System.out.println("Enter row: 0 to 2");
                row = scanner.nextInt();

                System.out.println("Enter col: 0 to 2");
                col = scanner.nextInt();

                // bounds check
                if (!isValid(row, col)) {
                    System.out.println("Out of bounds, try again!");
                    continue;
                }

                // occupancy check
                if (!board.isCellEmpty(row, col)) {
                    System.out.println("Cell already filled, try again!");
                    continue;
                }

                // valid move found
                break;
            }
            board.placeMark(row, col, currentPlayer.symbol);

            if(board.hasWinner(currentPlayer.symbol)){
                board.printBoard();
                System.out.println(currentPlayer.name + "wins!");
                return;
            }

            if(board.isFull()){
                board.printBoard();
                System.out.println("Board is full, game is drawn");
                return;
            }

            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }

        

        // while(true){
        //     if(currentPlayer == player1){
        //         System.out.println("Your turn: " + player1.name);
        //     }
        //     else if(currentPlayer == player2) System.out.println("Your turn: " + player2.name);

        //     System.out.println("Enter row");
        //     row = scanner.nextInt();
        //     System.out.println("Enter col");
        //     col = scanner.nextInt();

        //     // Check if out of bounds
        //     if(!isValid(row, col)){
        //         System.out.println("Out of bounds, try again!");
        //         continue;
        //     }

        //     makemove(row, col);

        //     board.printBoard();

        //     if(board.hasWinner(player1.symbol)){
        //         System.out.println(player1.name + " wins");
        //         return;
        //     }
        //     if(board.hasWinner(player2.symbol)){
        //         System.out.println(player2.name + " wins");
        //         return;
        //     }
        //     if(board.isFull()){
        //         System.out.println("Game is drawn.");
        //         return;
        //     }
        // }
    }

    public void makemove(int row, int col){
        if(!board.isCellEmpty(row, col)){
            System.out.println("Move invalid, try again!");
            return;
        }
        
        
    }
}
