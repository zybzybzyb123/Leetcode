/**
 * 直接用的bfs,感觉比较好理解
 * 还有带权并查集的解法未实现
 */

class Solution {
    private static class Pair<K, V> {
        private K key;
        private V value;

        private Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private static <K, V> Pair of(K k, V v) {
            return new Pair(k, v);
        }
    }
    private Map<String, List<Pair<String, Double>>> map = new HashMap<>();
    private void addEdge(String a, String b, double value) {
        List<Pair<String, Double>> list = map.getOrDefault(a, new ArrayList<>());
        list.add(Pair.of(b, value));
        map.put(a, list);
    }
    private double calWeight(String a, String b) {
        if (!map.containsKey(a) || !map.containsKey(b)) {
            return -1.0;
        }
        if (a.equals(b)) {
            return 1.0;
        }
        Map<String, Double> vis = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(a);
        vis.put(a, 1.0);
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            double rootValue = vis.get(temp);
            if (temp.equals(b)) {
                return vis.get(b);
            }
            for (Pair<String, Double> pair : map.get(temp)) {
                String node = pair.key;
                double value = pair.value;
                if (!vis.containsKey(node)) {
                    queue.offer(node);
                    vis.put(node, value * rootValue);
                }
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            addEdge(a, b, values[i]);
            addEdge(b, a, 1.0 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            res[i] = calWeight(a, b);
        }
        return res;
    }
}