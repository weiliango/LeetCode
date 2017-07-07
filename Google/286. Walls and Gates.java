public class Solution {
    public class Point {
    int x;
    int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    Queue<Point> q;
    
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length < 1 || rooms[0].length < 1) return;
        q = new LinkedList<Point>();
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0)
                    q.add(new Point(i, j));
            }
        }
        int len = q.size();
        int lev = 0;
        while(!q.isEmpty()) {
            Point p = q.poll();
            if(p.x-1 >= 0 && rooms[p.x-1][p.y] == 2147483647) {
                q.add(new Point(p.x-1, p.y));
                rooms[p.x-1][p.y] = lev + 1;
            }
            if(p.y-1 >= 0 && rooms[p.x][p.y-1] == 2147483647) {
                q.add(new Point(p.x, p.y-1));
                rooms[p.x][p.y-1] = lev + 1;
            }
            if(p.x+1 < rooms.length && rooms[p.x+1][p.y] == 2147483647) {
                q.add(new Point(p.x+1, p.y));
                rooms[p.x+1][p.y] = lev + 1;
            }
            if(p.y+1 < rooms[0].length && rooms[p.x][p.y+1] == 2147483647) {
                q.add(new Point(p.x, p.y+1));
                rooms[p.x][p.y+1] = lev + 1;
            }
            if(--len == 0) {
                len = q.size();
                lev++;
            }
        }
    }
}

//optimization: change the Point class to int array