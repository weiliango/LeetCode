class Solution {
    public int findLonelyPixel(char[][] picture) {
        int ret = 0;
        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[0].length; j++) {
                if(picture[i][j] == 'B') {
                    ret++;
                    flip(picture, i, j);
                }
            }
        }
        return ret;
    }
    private void flip(char[][] picture, int x, int y) {
        int[][] moves = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] move: moves) {
            int nx = x + move[0];
            int ny = y + move[1];
            if(nx >= 0 || nx < picture.length || ny >= 0 || ny < picture[0].length) {
                if(picture[nx][ny] == 'B') {
                    picture[nx][ny] = 'W';
                    flip(picture, nx, ny);
                }
            }
        }
    }
}

//wrong answer, misunderstood the question

class Solution {
    public int findLonelyPixel(char[][] picture) {
        boolean[] row = new boolean[picture.length];
        boolean[] col = new boolean[picture[0].length];
        int ret = 0;
        for(int i = 0; i < picture.length; i++) {
            for(int j = 0; j < picture[0].length; j++) {
                if(picture[i][j] == 'B' && !row[i] && !col[j]) {
                    row[i] = true;
                    col[j] = true;
                    if(check(i, j, picture))
                        ret++;
                }
            }
        }
        return ret;
    }
    private boolean check(int x, int y, char[][] picture) {
        for(int i = 0; i < picture.length; i++) {
            if(i != x && picture[i][y] == 'B')
                return false;
        }
        for(int j = 0; j < picture[0].length; j++) {
            if(j != y && picture[x][j] == 'B')
                return false;
        }
        return true;
    }
}