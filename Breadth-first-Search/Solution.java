import java.util.*;
public class Solution {
    public class Point {
        int x;
        int y;
        Point( int x, int y ) {
            this.x = x;
            this.y = y;
        }
    }
    public void solve(char[][] board) {
        if ( board.length <= 1 ) return ;

        int m = board.length;
        int n = board[0].length;
        Point p = new Point(0,0);

        boolean [][] b = new boolean[m][n];
        for ( int i = 0; i < m ; i++ ) {
            p.x = i;
            p.y = 0;
            bfs(board, b, m, n, p);
            p.y = n - 1;
            bfs(board, b, m, n, p);
        }
        for ( int j = 0; j < n; j++ ) {
            p.x = 0;
            p.y = j;
            bfs(board, b, m, n, p);
            p.x = m - 1;
            bfs(board, b, m, n, p);
        }

        for ( int i = 0; i < m ; i++ ) {
            for ( int j = 0; j < n ; j++ ) {
                if ( board[i][j] == 'O' && !b[i][j] ) {
                    board[i][j] = 'X';
                }
            }
        }

    }
    public void bfs(char[][] board, boolean[][] b, int m, int n, Point p) {
        if ( board[p.x][p.y] == 'X' || b[p.x][p.y]) {
            return;
        }

        Queue<Point> q = new LinkedList<Point>();
        
        q.add(p);
        while ( !q.isEmpty() ) {
            Point current = q.poll();
            b[current.x][current.y] = true;

            if ( current.x - 1 >= 0 ) {
                if ( board[current.x - 1][current.y] == 'O' && !b[current.x-1][current.y])
                    q.add(new Point(current.x - 1, current.y));
            }
            if ( current.x + 1 < m ) {
                if ( board[current.x + 1][current.y] == 'O' && !b[current.x+1][current.y])
                    q.add(new Point(current.x + 1, current.y));
            }
            if ( current.y - 1 >= 0 ) {
                if ( board[current.x][current.y-1] == 'O' && !b[current.x][current.y-1])
                    q.add(new Point(current.x, current.y - 1));
            }
            if ( current.y + 1 < n ) {
                if ( board[current.x][current.y+1] == 'O' && !b[current.x][current.y+1])
                    q.add(new Point(current.x, current.y + 1));
            }
        }       
    }
}
