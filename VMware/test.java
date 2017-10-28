/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    char[] sbuf = new char[1024];
    int start = 0;

    public Solution() {
        char[] buffer = new char[4];

        int len = 0;
        int rst = 0;
        while((len = read4(buffer)) != 0) {
            for(int i = rst; i < rst + len; i++)
                sbuf[i] = buffer[i-rst];
            rst += len;
        }
        sbuf = Arrays.copyOf(sbuf, rst);
    }
    public int read(char[] buf, int n) {
        int count = 0;
        while(count < n && start < sbuf.length) {
            buf[count++] = sbuf[start++];
        }
        return count;
    }
}