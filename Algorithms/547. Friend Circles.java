/**
 * 并查集，节点压缩
 */
class Solution {
    public int findCircleNum(int[][] M) {
        int[] pars = new int[205];
        for(int i = 0; i < M.length; i++){
            pars[i] = -1;
        }
        for(int i = 0; i < M.length; i++){
            for(int j = i + 1; j < M.length; j++){
                if(M[i][j] == 1){
                    int pi = i, pj = j;
                    while(pars[pi] >= 0){
                        pi = pars[pi];
                    }
                    while(pars[pj] >= 0){
                        pj = pars[pj];
                    }
                    int root = -1, p = -1;
//                    System.out.println("pi = " + pi + " , " + "pj = " + pj);
                    if(pi == pj){
                        root = pi;
                        p = j;
                    } else if(pars[pi] < pars[pj]){
                        pars[pi] += pars[pj];
                        pars[pj] = pi;
                        root = pi;
                        p = j;
                    } else{
                        pars[pj] += pars[pi];
                        pars[pi] = pj;
                        root = pj;
                        p = i;
                    }
                    //压缩节点
                    while(pars[p] >= 0){
                        int temp = pars[p];
                        pars[p] = root;
                        p = temp;
                    }
                }
            }
        }
        int ans = 0;
        for(int par : pars){
            if(par < 0){
                ans++;
            }
        }
        return ans;
    }
}