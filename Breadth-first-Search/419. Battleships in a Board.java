public class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'X') {
                    count++;
                    helper(board, i, j);
                }
            }
        }
        return count;
    }
    public void helper(char[][] board, int x, int y) {
        board[x][y] = '.';
        if((x + 1 < board.length) && (board[x+1][y] == 'X')) helper(board, x+1, y);
        if((x - 1 >= 0) && (board[x-1][y] == 'X')) helper(board, x-1, y);
        if((y + 1 < board[0].length) && (board[x][y+1] == 'X')) helper(board, x, y+1);
        if((y - 1 >= 0) && (board[x][y-1] == 'X')) helper(board, x, y-1);
    }
}