class Solution {
    public List<Integer> partitionLabels(String S) {
        char[] array = S.toCharArray();
        int[] right = new int[26];
        for(int i = array.length - 1; i >= 0; i--){
            int pos = array[i] - 'a';
            if(right[pos] == 0){
                right[pos] = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        int ans = 0, rMax = -1;
        for(int i = 0; i < array.length; i++){
            int pos = array[i] - 'a';
            rMax = rMax > right[pos] ? rMax : right[pos];
            if(rMax == i){
                list.add(ans + 1);
                ans = 0;
                rMax = -1;
            } else{
                ans++;   
            }
        }
        return list;
    }
}