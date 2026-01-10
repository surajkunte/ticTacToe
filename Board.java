package tictactoe;

// ⚠️ Important design idea

// Board does not know players
// Board does not know turns

// It just stores symbols.

// Think of Board as a dumb storage class.

public class Board {

    String board[][] = new String[3][3];

    Board(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = "";
            }
        }
    }

    boolean isCellEmpty(int row, int col){
        // return "".equals(board[row][col]);
        if (row < 0 || row >= 3 || col < 0 || col >= 3) return false;

        if("".equals(board[row][col])) return true;
        return false;
    }

    void placeMark(int row, int col, String symbol){
        board[row][col] = symbol;
    }

    boolean isFull(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if("".equals(board[i][j])) return false;
            }
        }
        return true;
    }

    void printBoard(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
            System.out.println();
        }
    }

    boolean hasWinner(String symbol){
        //checking one row at a time
        for(int i = 0; i < 3; i++){
            if(board[i][0].equals(symbol) &&
                board[i][1].equals(symbol) &&
                board[i][2].equals(symbol)){
                    return true;
            }
        }
        //checking one col at a time
        for(int j = 0; j < 3; j++){
            if(board[0][j].equals(symbol) &&
                board[1][j].equals(symbol) &&
                board[2][j].equals(symbol)){
                    return true;
            }
        }

        //check diagonal
        if(board[0][0].equals(symbol) &&
            board[1][1].equals(symbol) &&
            board[2][2].equals(symbol)){
                return true;
        }
        if(board[0][2].equals(symbol) &&
            board[1][1].equals(symbol) &&
            board[2][0].equals(symbol)){
                return true;
        }

        return false;
    }

};
