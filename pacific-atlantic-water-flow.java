class Solution {
    private static final int[][] directions={{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows=heights.length;
        int cols=heights[0].length;

        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];

        for(int c=0;c<cols;c++){
            dfs(0,c,pacific,heights);
            dfs(rows-1,c,atlantic,heights);
        }

        for(int r=0;r<rows;r++){
            dfs(r,0,pacific,heights);
            dfs(r,cols-1,atlantic,heights);
        }

        List<List<Integer>> result=new ArrayList<>();
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }

        return result;

    }

    private void dfs(int r,int c,boolean[][] visited,int[][] heights){
        visited[r][c]=true;
        for(int[] dir:directions){
            int nr=r+dir[0];
            int nc=c+dir[1];
            if(nr<0 || nc<0 || nr>=heights.length || nc>=heights[0].length || visited[nr][nc] || heights[nr][nc]<heights[r][c]){
                continue;
            }
            dfs(nr,nc,visited,heights);
        }
    }
}


/*
Time complexity: O(m∗n)
Space complexity: O(m∗n)
*/
