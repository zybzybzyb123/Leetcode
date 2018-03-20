class Solution {
    public int countBattleships(char[][] board) {
        if(board.length == 0 || board[0].length == 0){
            return 0;
        }
        int ans = 0;
        if(board[0][0] == 'X'){
            ans++;
        }
        for(int i = 1; i < board.length; i++){
            if(board[i][0] == 'X' && board[i - 1][0] != 'X'){
                ans++;
            }
        }
        for(int i = 1; i < board[0].length; i++){
            if(board[0][i] == 'X' && board[0][i - 1] != 'X'){
                ans++;
            }
        }
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[0].length; j++){
                if(board[i][j] == 'X' && board[i - 1][j] != 'X' && board[i][j - 1] != 'X'){
                    ans++;
                }
            }
        }
        return ans;
    }
}