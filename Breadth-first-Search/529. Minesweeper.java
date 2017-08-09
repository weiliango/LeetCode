public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        helper(board, click[0], click[1]);
        return board;
    }
    public void helper(char[][] board, int x, int y) {
        if(x < 0 || y < 0 || x >= board.length || y >= board[0].length) return;
        if(board[x][y] == 'M')
            board[x][y] = 'X';
        else if(board[x][y] == 'E') {
            int mines = calculateMinesAdjacent(board, x, y);
            if(mines == 0) {
                board[x][y] = 'B';
                for(int i = -1; i <= 1; i++) {
                    for(int j = -1; j <= 1; j++) {
                        helper(board, x+i, y+j);
                    }
                }
            } else {
                board[x][y] = (char) (mines + '0');
            }
        } else
            return;
    }
    
    public int calculateMinesAdjacent(char[][] board, int x, int y) {
        int sum = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {
                if( (x+i) < 0 || (x+i) >= board.length || (y+j) < 0 || (y+j) >= board[0].length)
                    continue;
                if(board[x+i][y+j] == 'M')
                    sum++;
            }
        }
        return sum;
    }
}