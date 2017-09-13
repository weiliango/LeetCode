class Solution {
    public String regroup(String str, int k) {
        int firstGroupLen = new String(str).replace("-", "").length() % k;
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while(idx < firstGroupLen)
            sb.append(str.charAt(idx++));
        if(idx < str.length())
            sb.append("-");
        int i = 0;
        while(idx < str.length()) {
            sb.append(str.charAt(idx));
            if(++i % k == 0)
                sb.append("-");
        }
        return sb.toString();
    }
}