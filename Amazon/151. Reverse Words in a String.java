public class Solution {
    public String reverseWords(String s) {
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >= 0; i--) {
            if(!strs[i].equals(""))
                sb.append(strs[i] + " ");
        }
        if(sb.length() != 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}