/**
 * 思路就是先记录s1各位字符出现的次数
 * 记录s2的各位字符出现的位置，针对没有
 * 出现过的字符直接更新子串首位，针对出现
 * 次数比s1中次数多的，就降子串首位更新为
 * 他第一次出现位置的下一个位置，每次更新都要
 * 记得把计数器相应的更新
 */

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] array1 = s1.toCharArray();
        char[] array2 = s2.toCharArray();
        int[] cnt = new int[26];
        int tot = 0, ans = 0, cur = -1;
        for(char ch : array1){
            cnt[ch - 'a']++;
            tot++;
        }
        List<Queue<Integer>> list = new ArrayList<>();
        //用队列保存每一个字符的出现位置
        for(int i = 0; i < 26; i++){
            Queue<Integer> queue = new LinkedList<>();
            list.add(queue);
        }
        for(int i = 0; i < array2.length; i++){
            int pos = array2[i] - 'a';
            //s1中没有的字符
            if(cnt[pos] == 0){
                for(int j = cur; cur >= 0 && j < i; j++){
                    list.get(array2[j] - 'a').poll();
                    ans--;
                }
                cur = -1;
                continue;
            }
            Queue<Integer> queue = list.get(pos);
            //s1 s2都有的字符，但是可能次数不同
            if(cnt[pos] > queue.size()){
                if(cur < 0) cur = i;
                queue.offer(i);
                ans++;
                if(ans == tot){
                    return true;
                }
            } else if(cnt[pos] == queue.size()){
                //出队少减1，最后入队就少加1
                int last = queue.poll();
                queue.offer(i);
                for(int j = cur; j < last; j++){
                    list.get(array2[j] - 'a').poll();
                    ans--;
                }
                //更新为第一次出现位置的下一个位置，肯定不会超过当前位置
                cur = last + 1;
            }
        }
        return false;
    }
}