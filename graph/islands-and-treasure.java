class Solution {
    private static final int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

    public void islandsAndTreasure(int[][] grid) {
        Queue<int []> q=new LinkedList<>();
        int rows=grid.length;
        int cols=grid[0].length;

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==0){
                    q.add(new int[]{r,c});
                }
            }
        }

        if(q.size()==0){
            return;
        }

        while(!q.isEmpty()){
            int[] node=q.poll();
            int r=node[0];
            int c=node[1];
            for(int[] dir:directions){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr<0 || nc<0 || nr>=rows || nc>=cols || grid[nr][nc]!=Integer.MAX_VALUE){
                    continue;
                }
                q.add(new int[]{nr,nc});
                grid[nr][nc]=grid[r][c]+1;
            }
        }
    }
}

/*
Time complexity: O(m∗n)
Space complexity: O(m∗n)
*/
