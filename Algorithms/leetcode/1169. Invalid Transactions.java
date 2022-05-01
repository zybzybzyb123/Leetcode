/***
 *  记录下吧,个人感觉这道题的质量很差,更像是在写业务代码
 *  而且题干的确不太清晰
 */

class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        if (transactions.length == 0) {
            return new ArrayList<>(0);
        }
        List<String> ans = new ArrayList<>();
        Inner[] inners = new Inner[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            inners[i] = Inner.of(transactions[i]);
        }
        Set<Integer> set =  new HashSet<>();
        for (int i = 0; i < inners.length; i++) {
            boolean flag = false;
            for (int j = i + 1; j < inners.length; j++) {
                if (inners[j].name.equals(inners[i].name) && Math.abs(inners[j].time - inners[i]
                        .time) <= 60 && !inners[j].city.equals(inners[i].city)) {
                    flag = true;
                    set.add(j);
                }
            }
            if (inners[i].amount > 1000 || flag) {
                set.add(i);
            }
        }
        for (int id : set) {
            ans.add(transactions[id]);
        }
        return ans;
    }

    static class Inner {
        private String name;
        private int time;
        private int amount;
        private String city;
        private Inner(){}
        private Inner(String name, int time, int amount, String city) {
            this.name = name;
            this.time = time;
            this.amount = amount;
            this.city = city;
        }
        public static Inner of(String transaction) {
            String[] array = transaction.split(",");
            return new Inner(array[0], Integer.valueOf(array[1]),
                    Integer.valueOf(array[2]), array[3]);
        }
    }
}