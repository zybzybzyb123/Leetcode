import java.util.Map;
import java.util.HashMap;
import java.util.UUID;
public class Codec {

    public static Map<String, String> shortToLong = new HashMap<>();
    public static Map<String, String> longToShort = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(null == longUrl){
            return null;
        }
        if(longToShort.get(longUrl) != null){
            return longToShort.get(longUrl);
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        if(longUrl.startsWith("https://")){
            sb.append("https://");
            cnt = 8;
        }
        if(longUrl.startsWith("http://")){
            sb.append("http://");
            cnt = 7;
        }
        String uuid = null;
        do{
            uuid = UUID.randomUUID().toString().replaceAll("-", "");
        }while (shortToLong.get(uuid) != null);
        int sz = Math.min(longUrl.length() - 1, uuid.length());
        String shortUrl = sb.toString() + uuid.substring(0, sz - cnt);
        longToShort.put(longUrl, shortUrl);
        shortToLong.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(null == shortUrl){
            return null;
        }
        return shortToLong.get(shortUrl);
    }
}
