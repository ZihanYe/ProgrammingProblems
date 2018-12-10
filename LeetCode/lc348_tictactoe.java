// LeetCode 348. Tic tac toe

class TicTacToe {
    int[] rows;
    int[] cols;
    int leftdiag;
    int rightdiag;
    int size;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows= new int[n];
        cols= new int[n];
        leftdiag = 0;
        rightdiag = 0;
        size = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int factor = player == 1 ? 1: -1;
        rows[row] += factor;
        if (rows[row] == factor * size) return player;
        cols[col] += factor;
        if (cols[col] == factor * size) return player;
        if (row == col) {
            leftdiag += factor;
            if (leftdiag == factor * size) return player;
        }
        if (row + col == size-1) {
            rightdiag += factor;
            if (rightdiag == factor * size) return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */