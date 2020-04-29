package Leetcode.extra;

import java.util.HashMap;
import java.util.Map;


/**
 * @author zero
 * @created 2020/04/29
 */
class SnapshotArray {

    private Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    private int[] array;
    private int snapId = 0;
    public SnapshotArray(int length) {
        array = new int[length];
    }
    
    public void set(int index, int val) {
        if (snapId == 0) {
            array[index] = val;
            return;
        }
        map.get(snapId).put(index, val);
    }
    
    public int snap() {
        map.put(snapId + 1, new HashMap<>());
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        for (int i = snap_id; i > 0; i--) {
            if (map.get(i).containsKey(index)) {
                return map.get(i).get(index);
            }
        }
        return array[index];
    }
}