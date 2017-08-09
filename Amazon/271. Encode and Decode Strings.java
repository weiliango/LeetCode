public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs) {
            sb.append(str.length());
            sb.append(',');
        }
        sb.append('#');
        for(String str: strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> strs = new LinkedList<String>();
        if(s.equals("#")) return strs;
        int idx = s.indexOf('#');
        int[] lengths = Stream.of(s.substring(0, idx - 1).split(",")).mapToInt(Integer::parseInt).toArray();
        String data = s.substring(idx + 1, s.length());
        int start = 0;
        for(int i = 0; i < lengths.length; i++) {
            strs.add(data.substring(start, lengths[i]+start));
            start += lengths[i];
        }
        return strs;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));