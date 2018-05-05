class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>(nums.length);
        for(int num : nums){
            if(!cnt.containsKey(num)){
                cnt.put(num, 1);
            } else{
                cnt.put(num, cnt.get(num) + 1);
            }
        }
        Queue<Integer> pq = new PriorityQueue<>(k, (a, b) -> {
            return cnt.get(a) - cnt.get(b);
        });
        for(int key : cnt.keySet()){
            if(pq.size() < k){
                pq.offer(key);
            } else{
                if(cnt.get(key) > cnt.get(pq.peek())){
                    pq.poll();
                    pq.offer(key);
                }
            }
        }
        return new ArrayList<>(pq);
    }
}