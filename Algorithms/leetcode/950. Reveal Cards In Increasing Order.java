/**
 * 用队列无脑水果，感觉不用队列模拟应该也是OK的，
 * 不过尾数处理有点麻烦
 */
class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        //System.out.println(Arrays.toString(deck));
        int[] ans = new int[deck.length];
        int id = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < deck.length; i++) {
            queue.offer(i);
        }
        while(!queue.isEmpty()) {
            int pos = queue.poll();
            //System.out.println("pos : " + pos);
            ans[pos] = deck[id++];
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
        }
        return ans;
    }
}