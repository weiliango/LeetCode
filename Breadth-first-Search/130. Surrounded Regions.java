public class Point {
	int x;
	int y;
	Point( int x, int y ) {
		this.x = x;
		this.y = y;
	}
}
public class Solution {
    public void solve(char[][] board) {
    	if ( board.length == 0 ) return ;

    	int m = board.length;
    	int n = board[0].length;

 		boolean [][] b = new boolean[m][n];
 		


    }
    public void bfs(char[][] board, boolean[][] b, int m, int n, Point p) {
        Queue<Point> q = new LinkedList<Point>();
        q.add(p);
        while ( !q.isEmpty() ) {
            
            
        }    	
    }
}