public class Solution {
	public class Point {
		int x;
		int y;
		public Point (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
    public int shortestDistance(int[][] grid) {
 		int distance = Integer.MAX_VALUE;
 		int count = 0;

 		for ( int i = 0; i < grid.length ; i++ ) {
 			for ( int j = 0; j < grid[0].length ; j++ ) {
 				if ( grid[i][j] == 1 ) {
 					count++;
				}
 			}
 		}

 		for ( int i = 0; i < grid.length ; i++ ) {
 			for ( int j = 0; j < grid[0].length ; j++ ) {
		 		boolean [][] b = new boolean[grid.length][grid[0].length];
 				distance = Math.min(distance, bfs(grid, new Point(i,j), b, count));
 			}
 		}

 		return distance == Integer.MAX_VALUE || distance == 0 ? -1 : distance;
    }

    public int bfs (int [][] grid,Point p, boolean[][] b, int count) {
        if( grid[p.x][p.y] == 1 || grid[p.x][p.y] == 2 ) return Integer.MAX_VALUE;
        
    	int m = grid.length;
    	int n = grid[0].length;

    	Queue <Point> q = new LinkedList <Point> ();
    	q.add(p);
    	
    	int pathSum = 0;
    	int levelSize = q.size();
    	int radius = 0;

    //	int count = m * n;
    	b[p.x][p.y] = true;

    	while ( !q.isEmpty() ) {
    		Point current = q.poll();
    		if ( grid[current.x][current.y] == 0 ) {
    			if ( current.x - 1 >= 0 && !b[current.x-1][current.y]) {
    				b[current.x-1][current.y] = true;
    				q.add(new Point(current.x-1, current.y));
    			}
    			if ( current.x + 1 < m && !b[current.x+1][current.y]) {
    				b[current.x+1][current.y] = true;
    				q.add(new Point(current.x+1, current.y));
    			}
    			if ( current.y - 1 >= 0 && !b[current.x][current.y-1]) {
    				b[current.x][current.y-1] = true;
    				q.add(new Point(current.x, current.y-1));
    			}
    			if ( current.y + 1 < n && !b[current.x][current.y+1]) {
    				b[current.x][current.y+1] = true;
    				q.add(new Point(current.x, current.y+1));
    	        }
    		}

    		if ( grid[current.x][current.y] == 1) {
    	        pathSum += radius;
    	        count--;
    		}

    		if ( --levelSize == 0 ) {
    			levelSize = q.size();
    			radius++;
    		}
    	}
    	return count == 0 ? Integer.MAX_VALUE : pathSum;
    }
}