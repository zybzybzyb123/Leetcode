/**
 * java直接无脑过了,这本身也是一道烂题
 */

class Solution {
    public String entityParser(String text) {
        return
                text
                        .replaceAll("&quot;", "\"")
                        .replaceAll("&apos;", "\'")
                        .replaceAll("&amp;", "&")
                        .replaceAll("&gt;", ">")
                        .replaceAll("&lt;", "<")
                        .replaceAll("&frasl;", "/");
    }
}