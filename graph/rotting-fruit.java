class Solution {
    private static final int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        int fresh=0;
        int time=0;

        int rows= grid.length;
        int cols=grid[0].length;
        Queue<int[]> q=new LinkedList<>();

        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    fresh++;
                }
                else if(grid[r][c]==2){
                    q.add(new int[]{r,c});
                }
            }
        }

        while(fresh>0 && !q.isEmpty()){
            int len=q.size();
            for(int i=0;i<len;i++){
                int[] node=q.poll();
                int r=node[0];
                int c=node[1];

                for(int[] dir:directions){
                    int nr=r+dir[0];
                    int nc=c+dir[1];
                    if(nr<0 || nc<0 || nr>=rows || nc>=cols || grid[nr][nc]==2 || grid[nr][nc]==0){
                        continue;
                    }
                    q.add(new int[]{nr,nc});
                    grid[nr][nc]=2;
                    fresh--;
                }
            }
            time++;
        }

        return fresh==0?time:-1;
    }
}

/*
Time complexity: O(m∗n)
Space complexity: O(m∗n)
*/
