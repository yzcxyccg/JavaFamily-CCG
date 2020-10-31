package d15_leetcode;

/**
 * surrounded-regions
 * 现在有一个仅包含‘X’和‘O’的二维板，请捕获所有的被‘X’包围的区域,捕获一个被包围区域的方法是将被
 * 包围区域中的所有‘O’变成‘X’,例如：X X X X↵X O O X↵X X O X↵X O X X
 * 执行完你给出的函数以后，这个二维板应该变成：X X X X↵X X X X↵X X X X↵X O X X
 */
public class Test21 {
    public void solve(char[][] board) {
        if(board == null || board.length == 0)return;
        int m = board.length;
        int n = board[0].length;
        if(m < 3 || n < 3)return;
        //遍历上边缘
        for(int i = 0,j = 0 ; j < n ;j++){
            if(board[i][j] == 'O')
                spread(board,i,j);
        }
        //遍历下边缘
        for(int i = m-1,j = 0 ; j < n ;j++){
            if(board[i][j] == 'O')
                spread(board,i,j);
        }
        //遍历左边缘
        for(int i = 0,j = 0 ; i < m ;i++){
            if(board[i][j] == 'O')
                spread(board,i,j);
        }
        //遍历右边缘
        for(int i = 0,j = n-1 ; i < m ;i++){
            if(board[i][j] == 'O')
                spread(board,i,j);
        }
        //替换O为X,A为O
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == 'A')
                    board[i][j] = 'O';
            }
        }
    }
    public void spread(char[][] board,int i,int j){
        int m = board.length;
        int n = board[0].length;
        board[i][j] = 'A';
        if(j+1 < n && board[i][j+1] == 'O')
            spread(board,i,j+1);
        if(j-1 >= 0 && board[i][j-1] == 'O')
            spread(board,i,j-1);
        if(i+1 < m && board[i+1][j] == 'O')
            spread(board,i+1,j);
        if(i-1 >= 0 && board[i-1][j] == 'O')
            spread(board,i-1,j);
    }
}
