public class Solution {
    public void gameOfLife(int[][] board) {
        if(board.length > 0 && board[0].length > 0)
            update(board, 0, 0);
    }
    
    private void update(int[][] board, int x, int y) {
        int nextState = board[x][y];
        int liveOrDead = liveCounts(board, x, y);
        if(board[x][y] == 1) {
            if(liveOrDead < 2 || liveOrDead > 3)
                nextState = 0;
        } else {
            if(liveOrDead == 3)
                nextState = 1;
        }
        int nextx, nexty;
        nextx = x;
        nexty = y + 1;
        if( nexty >= board[0].length) {
            nexty = 0;
            nextx += 1;
        }
        if( nextx < board.length) {
            update(board, nextx, nexty);
        }
        board[x][y] = nextState;
    }
    
    private int liveCounts(int[][] board, int x, int y) {
        return ((x >= 1 && y >= 1) ? board[x-1][y-1] : 0) +
               ((x >= 1) ? board[x-1][y] : 0) +
               ((y >= 1) ? board[x][y-1] : 0) +
               ((x + 1 < board.length) ? board[x+1][y] : 0) +
               ((y + 1 < board[0].length) ? board[x][y+1] : 0) +
               (((x + 1 < board.length) && (y + 1 < board[0].length)) ? board[x+1][y+1] : 0) +
               (((x + 1 < board.length) && y >= 1) ? board[x+1][y-1] : 0) +
               (((y + 1 < board[0].length) && x >= 1) ? board[x-1][y+1] : 0);
    }
}

// we can use bit to solve this problem 1->1 11 1->0 10 0->1 01 0->0 00  >> <<