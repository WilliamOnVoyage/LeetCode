
package algorithm;

import java.util.*;

public class EncodeTinyURL {
	private String url_prefix = "http://tinyurl.com/";
	private HashMap<String, String> map = new HashMap<>();
	private HashMap<String, String> reverse_map = new HashMap<>();
	private final int length = 6;
	private char[] sets = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f',
			'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A',
			'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
			'W', 'X', 'Y', 'Z' };

	public String encode(String longUrl) {
		StringBuilder sb;
		while (true) {
			sb = new StringBuilder();
			for (int i = 0; i < length; i++) {
				sb.append(sets[(int) Math.random() * sets.length]);
			}
			if (!map.containsKey(sb.toString()))
				break;
		}
		map.put(sb.toString(), longUrl);
		reverse_map.put(longUrl, sb.toString());
		return url_prefix + sb.toString();
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl) {
		return map.get(shortUrl.substring(url_prefix.length()));
	}
	
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}