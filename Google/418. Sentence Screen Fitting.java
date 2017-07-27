public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int times = 0;
        int idx = 0;
        for(int row = 0; row < rows; row++) {
            int col = cols;
            while(true) {
                if(col == cols) {
                    if(cols < sentence[idx].length()) return 0;
                    col -= sentence[idx].length();
                    idx++;
                } else {
                    col -= 1;
                    if(col < sentence[idx].length()) break;
                    col -= sentence[idx].length();
                    idx++;
                }
                if(idx == sentence.length) {
                    times++;
                    idx = 0;
                }
            }
        }
        return times;
    }
}

//Time Limit Exceed

public class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        
    }
}