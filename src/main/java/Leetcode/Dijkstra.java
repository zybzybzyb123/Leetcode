package Leetcode;

import java.util.Arrays;


public class Dijkstra {
    public String happy(int n, int[][] roads, String[] codes) {
        int[][] weight = new int[n + 1][n + 1];
        for (int i = 0; i < weight.length; i++) {
            Arrays.fill(weight[i], Integer.MAX_VALUE);
        }
        for (int[] road : roads) {
            if (road[0] != road[1] && weight[road[0]][road[1]] < road[2]) {
                weight[road[0]][road[1]] = road[2];
                weight[road[1]][road[0]] = road[2];
            }
        }
        int start = 11, end = 0;
        int[] path = dijkstra(weight, start, end);
        StringBuilder sb = new StringBuilder();
        for (int i = end; i != start; i = path[i]) {
            System.out.println("index : " + i);
            sb.append(codes[i]);
        }
        sb.append(codes[start]);
        return sb.reverse().toString();
    }

    public static int[] dijkstra(int[][] weight, int start, int end) {
        int n = weight.length; // 顶点个数
        int[] shortPath = new int[n]; // 保存start到其他各点的最短路径
        Arrays.fill(shortPath, Integer.MAX_VALUE);
        shortPath[start] = 0;
        int[] path = new int[n]; // 保存start到其他各点最短路径的字符串表示
        int[] visited = new int[n]; // 标记当前该顶点的最短路径是否已经求出,1表示已求出

        for (int count = 0; count < n; count++) { // 要加入n-1个顶点
            int k = -1; // 选出一个距离初始顶点start最近的未标记顶点
            int dmin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && shortPath[i] < dmin) {
                    dmin = shortPath[k = i];
                }
            }
            visited[k] = 1;
            // 以k为中间点，修正从start到未访问各点的距离
            for (int i = 0;  i < n; i++) {
                //如果 '起始点到当前点距离' + '当前点到某点距离' < '起始点到某点距离', 则更新
                if (shortPath[i] - shortPath[k] > weight[k][i]) {
                    shortPath[i] = shortPath[k] + weight[k][i];
                    path[i] = k;
                }
            }
        }
        return path;
    }
    
}