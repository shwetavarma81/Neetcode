class Solution {
    private static int[][] directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

    public void solve(char[][] board) {
        int rows=board.length;
        int cols=board[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='O' && (r==0 || r==rows-1 || c==0 || c==cols-1)){
                    dfs(r,c,board);
                }
            }
        }

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(board[r][c]=='O'){
                    board[r][c]='X';
                } else if(board[r][c]=='T'){
                    board[r][c]='O';
                }
            }
        }
    }

    private void dfs(int r,int c, char[][] board){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length || board[r][c]!='O'){
            return;
        }
        board[r][c]='T';
        for(int[] dir:directions){
            dfs(r+dir[0],c+dir[1],board);
        }
    }
}

/*
Time complexity: O(m∗n)
Space complexity: O(m∗n)
  */
