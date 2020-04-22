/**
 * 一道毫无质量的烂题, 客户不用保存,完全没用
 * 详细见注释
 */

class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // table -> food + cnt
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        Set<String> foodSet = new TreeSet<>();
        for (List<String> order : orders) {
            int table = Integer.valueOf(order.get(1));
            String food = order.get(2);
            foodSet.add(food);
            Map<String, Integer> foodCntMap = map.getOrDefault(table, new HashMap<>());
            foodCntMap.put(food, foodCntMap.getOrDefault(food, 0) + 1);
            map.put(table, foodCntMap);
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        firstRow.addAll(foodSet);
        ans.add(firstRow);
        for (int i = 1; i <= 500; i++) {
            if (map.containsKey(i)) {
                List<String> temp = new ArrayList<>();
                temp.add(String.valueOf(i));
                Map<String, Integer> foodCntMap = map.get(i);
                for (String food : foodSet) {
                    temp.add(String.valueOf(foodCntMap.getOrDefault(food, 0)));
                }
                ans.add(temp);
            }
        }
        return ans;
    }
}