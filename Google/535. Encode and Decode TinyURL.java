public class Codec {
    ArrayList<String> list = new ArrayList<>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        list.add(longUrl);
        return "" + (list.size() - 1);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return list.get(Integer.parseInt(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));

public class Codec {
    HashMap<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        map.put("" + longUrl.hashCode(), longUrl);
        return "" + longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));