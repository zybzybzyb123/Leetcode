class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        String[] temp = new String[1005];
        Map<String, Integer> pos = new HashMap<>();
        int Min = 2000, sz = 0;
        for (int i = 0; i < list1.length; i++) {
            pos.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if(pos.get(list2[i]) != null){
                int cur = pos.get(list2[i]) + i;
                if(cur < Min){
                    Min = cur;
                    sz = 0;
                    temp[sz++] = list2[i];
                } else if(cur == Min){
                    temp[sz++] = list2[i];
                }
            }
        }
        return Arrays.copyOf(temp, sz);
    }
}