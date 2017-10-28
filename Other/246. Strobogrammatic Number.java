class Solution {
    HashMap<Character, Character> map;
    public Solution() {
        map = new HashMap<>();
        map.put('0', '0');
        map.put('1', '1');
        map.put('6', '9');
        map.put('9', '6');
        map.put('8', '8');
    }
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0)
            return true;
        if(num.length() == 1)
            return num.charAt(0) == '0' || num.charAt(0) == '1' || num.charAt(0) == '8';
        return map.containsKey(num.charAt(0))
            && map.get(num.charAt(0)) == num.charAt(num.length()-1)
            && isStrobogrammatic(num.substring(1, num.length()-1));
    }
}