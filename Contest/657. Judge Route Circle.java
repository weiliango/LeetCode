public class Solution {
    public boolean judgeCircle(String moves) {
        int[] p = new int[2];
        p[0] = 0;
        p[1] = 0;
        for(char move: moves.toCharArray()) {
            if(move == 'U')
                p[1]--;
            else if(move == 'D')
                p[1]++;
            else if(move == 'L')
                p[0]--;
            else
                p[0]++;
        }
        if(p[0] == 0 && p[1] == 0)
             return true;
        return false;
    }
}