package tictactoe;

public class Move{
    int row;
    int col;
    Player player;

    Move(int row, int col, Player player){
        this.row = row;
        this.col = col;
        this.player = player;
    }
}
