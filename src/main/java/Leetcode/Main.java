package Leetcode;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

//CHECKSTYLE:OFF
class Solution {
    public int longestSubstring(String s, int k) {
        return 0;
    }
    public int[] beautifulArray(int N) {
        return null;
    }
    public int largestOverlap(int[][] A, int[][] B) {
        int[] cnt = new int[2000];
        int len1 = 0, len2 = 0;
        System.out.format("A len : %d\n", A.length);
        int[] pos1 = new int[A.length * A.length + 10];
        int[] pos2 = new int[pos1.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    pos1[len1++] = i * 30 + j;
                }
                if (B[i][j] == 1) {
                    pos2[len2++] = i * 30 + j;
                }
            }
        }
        int ans = 0;
        System.out.format("len1 = %d, len2 = %d\n", len1, len2);
        System.out.format("pos1 = %s\n", Arrays.stream(pos1).limit(len1).boxed().collect(toList()));
        System.out.format("pos2 = %s\n", Arrays.stream(pos2).limit(len2).boxed().collect(toList()));
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
//                System.out.format("pos2[j] - pos1[i] = %d\n", pos2[j] - pos1[i]);
                cnt[pos2[j] - pos1[i] + 1000]++;
                ans = Math.max(cnt[pos2[j] - pos1[i] + 1000], ans);
            }
        }
        return ans;
    }

    public int largestOverlap1(int[][] A, int[][] B) {
        Map<Integer, Integer> cnt = new HashMap<>();
        List<Integer> pos1 = new ArrayList<>();
        List<Integer> pos2 = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    pos1.add(i * 32 + j);
                }
                if (B[i][j] == 1) {
                    pos2.add(i * 32 + j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < pos1.size(); i++) {
            for (int j = 0; j < pos2.size(); j++) {
                int key = pos2.get(j) - pos1.get(i);
                int val = cnt.getOrDefault(key,0);
                if (val == 481) {
                    System.out.printf("pos1 = %d, pos2 = %d\n", pos1.get(i), pos2.get(j));
                }
                ans = Math.max(val + 1, ans);
                cnt.put(key, val + 1);
            }
        }
        return ans;
    }

    public boolean isValid(String S) {
        LinkedList<Integer> stash = new LinkedList<>();
        for (char ch : S.toCharArray()) {
            int val = ch - 'a';
            if (val == 0) {
                stash.push(val);
            } else if (val == 1) {
                if (stash.size() < 1 || stash.peek() != 0) {
                    return false;
                }
                stash.push(val);
            } else {
                if (stash.size() < 2) {
                    return false;
                }
                int x = stash.pop(), y = stash.pop();
                if (x != 1 || y != 0) {
                    return false;
                }
            }
        }
        return stash.isEmpty();
    }

    public int[][] kClosest(int[][] points, int K) {
//        Arrays.sort(points, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] + o2[1] * o2[1];
//            }
//        });
        Arrays.sort(points, (o2, o1) -> o1[0] * o1[0] + o1[1] * o1[1] - o2[0] * o2[0] + o2[1] *
                o2[1]
        );

        int[][] ans = new int[K][2];
        System.arraycopy(points, 0, ans, 0, K);
        return ans;
    }

    private void init(Set<String> set) {
        for (int i = 0; i < 31; i++) {
            char[] array = String.valueOf(1 << i).toCharArray();
            Arrays.sort(array);
            set.add(new String(array));
        }
    }

    public boolean reorderedPowerOf2(int N) {
        Set<String> set = new HashSet<>();
        init(set);
        char[] array = String.valueOf(N).toCharArray();
        Arrays.sort(array);
        return set.contains(new String(array));
    }

    private boolean noMore(char[] a, char[] b) {
        if (a.length != b.length) {
            return a.length < b.length;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return a[i] < b[i];
            }
        }
        return true;
    }

    public boolean queryString(String S, int N) {
        char[] array = S.toCharArray();
        Set<String> set = new HashSet<>(N);
        char[] binaryArray = Integer.toBinaryString(N).toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '0') {
                continue;
            }
            for (int j = i + 1; j <= array.length; j++) {
                if (j - i > binaryArray.length) {
                    break;
                }
                char[] temp = Arrays.copyOfRange(array, i, j);
//                    System.out.format("temp = %s, binary = %s\n", new String(temp), new String(binaryArray));
                if (noMore(temp, binaryArray)) {
                    set.add(new String(temp));
                }
            }
        }
        return set.size() == N;
    }
}

public class Main {
    public static void main(String[] args){
//        FileInputStream file = new FileInputStream('in.txt');
//        System.setIn(file);
        Solution solution = new Solution();
//        System.out.println(solution.queryString("0110", 3));
//        int[][] A = {};
//        int[][] B = {};
//        System.out.println(solution.largestOverlap(A, B));
//        String str = "abcabcababcc";
//        System.out.println(solution.isValid(str));
    }
}
