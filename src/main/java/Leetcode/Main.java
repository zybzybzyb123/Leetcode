package Leetcode;

import Leetcode.dataStructure.base.ListNode;
import Leetcode.dataStructure.base.TreeNode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author zero
 * @created 2020/04/29
 */

class Solution {

    public int[] mergeList(int[] listA, int n, int[] listB, int m) {
        if (listA == null || listA.length == 0) {
            return listB;
        }
        if (listB == null || listB.length == 0) {
            return listA;
        }
        int[] listC = listA.length > listB.length ? listA : listB;
        int idxC = listC.length - 1, idxA = n - 1, idxB = m - 1;
        while (idxA >= 0 && idxB >= 0) {
            if (listA[idxA] >= listB[idxB]) {
                listC[idxC--] = listA[idxA--];
            } else {
                listC[idxC--] = listB[idxB--];
            }
        }
        while (idxA >= 0) {
            listC[idxC--] = listA[idxA--];
        }
        while (idxB >= 0) {
            listC[idxC--] = listB[idxB--];
        }
        return listA;
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
        int[] listA = {1,2,3,0,0,0};
        int[] listB = {3,3,4};
        int[] listC = solution.mergeList(listA, 3, listB, 3);
        System.out.println(Arrays.toString(listC));
    }
}
