class Solution {
    public boolean validTicTacToe(String[] board) {
        int player1 = 0, player2 = 0;
        int win1 = 0, win2 = 0;
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < board.length; j++) {
                char ch = board[i].charAt(j);
                if(ch == 'X'){
                    player1++;
                } else if(ch == 'O'){
                    player2++;
                }
            }
        }
        if(player1 < player2 || player1 > player2 + 1) return false;
        for(int i = 0; i < 3; i++){
            char chc = board[i].charAt(2);
            char chr = board[2].charAt(i);
            if(chc == board[i].charAt(1) && chc == board[i].charAt(0)){
                if(chc == 'X'){
                    win1++;
                } else if(chc == 'O'){
                    win2++;
                }
            }
            if((chr == board[1].charAt(i) && chr == board[0].charAt(i))){
                if(chr == 'X'){
                    win1++;
                } else if(chr == 'O'){
                    win2++;
                }
            }
        }
        char chm = board[1].charAt(1);
        if((chm == board[0].charAt(0) && chm == board[2].charAt(2))
                || (chm == board[0].charAt(2) && chm == board[2].charAt(0))){
            if(chm == 'X'){
                win1++;
            } else if(chm == 'O'){
                win2++;
            }
        }
        if(win1 + win2 > 1) return false;
        if((player1 > player2 && win2 == 1)||((player1 == player2 && win1 == 1))){
            return false;
        }
        return true;
    }
}