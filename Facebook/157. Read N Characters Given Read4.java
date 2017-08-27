/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        char[] buffer = new char[4];
        int ret = read4(buffer);
        int total = 0;
        while(ret == 4) {
            int i = 0;
            while(total <= n) {
                buf[total++] = buffer[4-ret+(i++)];
            }
            ret = read4(buffer);
        }
        if(ret != 0) {
            int i = 0;
            while(total <= n) {
                buf[total++] = buffer[4-ret+(i++)];
            }
        }
        return Math.min(n, total);
    }
}