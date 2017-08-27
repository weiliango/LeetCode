public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new LinkedList<String>();
        int lastIdx = 0;
        int width = 0;
        int zeroLenCount = 0;
        for(int i = 0; i < words.length; i++) {
           if(width + 1 + words[i].length() > maxWidth) {
                addToRes(words, lastIdx, i - 1, res, width, maxWidth, zeroLenCount);
                lastIdx = i;
                width = words[i].length();
                zeroLenCount = (words[i].length() == 0 ? 1 : 0);
           } else {
                if(width != 0 && words[i].length() != 0)
                    width++;
                if(words[i].length() == 0)
                    zeroLenCount++;
                width += words[i].length();
           }
        }
        addToRes(words, lastIdx, words.length - 1, res, width, maxWidth, zeroLenCount);
        return res;
    }
    private void addToRes(String[] words, int start, int end, List<String> res, int width, int maxWidth, int zeroLenCount) {
        StringBuilder sb = new StringBuilder();
        if(start == end) {
            sb.append(words[start]);
            appendSpace(sb, maxWidth - width);
        } else {
            width -= (end - start);
            int baseSpaceCount = (maxWidth - width) / (end - start - zeroLenCount);
            int suffixSpaceCount = (maxWidth - width) % (end - start - zeroLenCount);
            // System.out.println(width);
            // System.out.println(baseSpaceCount);
            // System.out.println(suffixSpaceCount);
            while(start < end) {
                sb.append(words[start]);
                if(words[start].length() != 0)
                    appendSpace(sb, baseSpaceCount + (suffixSpaceCount-- > 0 ? 1 : 0));
                start++;
            }
            sb.append(words[end]);
        }
        res.add(sb.toString());
    }
    private void appendSpace(StringBuilder sb, int count) {
        while(count-- > 0)
            sb.append(" ");
    }
}