/**
* 可以用选择排序或者优先队列(内部构造一个item类)
*/
class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() == 0) return s;
        char[] array = s.toCharArray();
        Map<Character, Integer> cnt = new HashMap<>();
        for(char ch : array){
            if(!cnt.containsKey(ch)){
                cnt.put(ch, 1);
            } else{
                cnt.put(ch, cnt.get((ch)) + 1);
            }
        }
        List<Character> list = new ArrayList<>(cnt.keySet());
        Collections.sort(list, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return cnt.get(o2) - cnt.get(o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Character character : list){
            int times = cnt.get(character);
            while(times > 0){
                times--;
                sb.append(character);
            }
        }
        return sb.toString();
    }
}