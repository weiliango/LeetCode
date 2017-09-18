import java.util.*;
public class Solution {
    public static void main(String[] args) {
        System.out.println(twinString("abc", "bac"));
    }
    public static boolean twinString(String a, String b) {
        if(a.length() != b.length()) return false;
        
        HashMap<Character, Integer> odd_s1 = new HashMap<>();
        HashMap<Character, Integer> odd_s2 = new HashMap<>();
        
        HashMap<Character, Integer> even_s1 = new HashMap<>();
        HashMap<Character, Integer> even_s2 = new HashMap<>();
        
        int len = a.length();
        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) {
                if(!even_s1.containsKey(a.charAt(i)))
                    even_s1.put(a.charAt(i), 0);
                if(!even_s2.containsKey(b.charAt(i)))
                    even_s2.put(b.charAt(i), 0);
                even_s1.put(a.charAt(i), even_s1.get(a.charAt(i)) + 1);
                even_s2.put(b.charAt(i), even_s2.get(b.charAt(i)) + 1);
            } else {
                if(!odd_s1.containsKey(a.charAt(i)))
                    odd_s1.put(a.charAt(i), 0);
                if(!odd_s2.containsKey(b.charAt(i)))
                    odd_s2.put(b.charAt(i), 0);
                odd_s1.put(a.charAt(i), odd_s1.get(a.charAt(i)) + 1);
                odd_s2.put(b.charAt(i), odd_s2.get(b.charAt(i)) + 1);
            }
        }
        
        return odd_s1.equals(odd_s2) && even_s1.equals(even_s2);
    }
}