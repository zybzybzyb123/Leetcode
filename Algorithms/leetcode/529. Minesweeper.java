/**
 * 思路广度优先搜索，处理为'E'的格子
 */


class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if(board[x][y] == 'B') return board;
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        //定义方向数组
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int m = board.length, n = board[0].length;
        int[][] cnt = new int[m][n];
        //预先计算每个格子的雷数
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'M'){
                    for(int[] pos : dir){
                        int dx = i + pos[0];
                        int dy = j + pos[1];
                        if(dx >= 0 && dx < m && dy >= 0 && dy < n && board[dx][dy] == 'E'){
                            cnt[dx][dy]++;
                        }
                    }
                }
            }
        }
        if(cnt[x][y] > 0){
            board[x][y] = (char)(cnt[x][y] + '0');
        } else{
            Queue<Integer> queue = new LinkedList<>();
            queue.add(x * 100 + y);
            while(!queue.isEmpty()){
                int temp = queue.poll();
                int tx = temp / 100, ty = temp % 100;
                board[tx][ty] = 'B';
                for(int[] pos : dir){
                    int dx = tx + pos[0];
                    int dy = ty + pos[1];
                    if(dx >= 0 && dx < m && dy >= 0 && dy < n && board[dx][dy] == 'E'){
                        if(cnt[dx][dy] > 0){
                            board[dx][dy] = (char)(cnt[dx][dy] + '0');
                        } else{
                            board[dx][dy] = 'B';
                            queue.offer(dx * 100 + dy);
                        }
                    }
                }
            }
        }
        return board;
    }
}