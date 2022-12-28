package Leetcode;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zero
 * @created 2020/04/29
 */

class Solution {

    public int minimumLength(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right &&
                s.charAt(left) == s.charAt(right)) {
            char ch = s.charAt(left);
            while (left <= right && s.charAt(left) == ch) {
                left++;
            }
            while (left <= right && s.charAt(right) == ch) {
                right--;
            }
        }
        return right - left + 1;
    }
}



public class Main {

    public static void main(String[] args) throws IOException {
//        String filePath = "src/main/java/Leetcode/in.txt";
//        FileInputStream inputStream = new FileInputStream(filePath);
//        System.setIn(new BufferedInputStream(inputStream));
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line = reader.readLine();
        Solution solution = new Solution();
    }
}
