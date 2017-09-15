// you can also use imports, for example:
// import java.util.*;
import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String S) {
        // write your code in Java SE 8
        if(S == null || S.length() != 5 || S.indexOf(":") != 2 || S.lastIndexOf(":") != 2) return S;
        
        HashSet<Character> set = new HashSet<>();
        String[] time = S.split(":");
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        S = S.replace(":", "");
        for(char ch: S.toCharArray())
            set.add(ch);
        for(int i = 1; i < 3600; i++) {
            // System.out.println(hour);
            minute += 1;
            int carry = minute / 60;
            minute %= 60;
            hour += carry;
            hour %= 24;
            String candidate = timeFactory(hour, minute);
            // System.out.println(candidate);
            if(validate(set, candidate))
                return candidate;
        }
        return "";
    }
    private String timeFactory(int hour, int minute) {
        StringBuilder time = new StringBuilder(hour + ":" + minute);
        if(minute < 10)
            time.insert(time.length() - 1, '0');
        if(hour < 10)
            time.insert(0, '0');
        return time.toString();
    }
    private boolean validate(HashSet<Character> set, String candidate) {
        for(char ch: candidate.toCharArray())
            if(ch != ':' && !set.contains(ch)) return false;
        return true;
    }
}