class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        List<List<Integer>> adj=new ArrayList<>();
        int n=edges.length;
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean[] visited=new boolean[n+1];

            if(dfs(u,-1,visited,adj)){
                return edge;
            }
        }

        return new int[0];
    }

    private boolean dfs(int node,int parent,boolean[] visited,List<List<Integer>> adj){
        if(visited[node]){
            return true;
        }

        visited[node]=true;
        for(int neigh:adj.get(node)){
            if(neigh==parent){
                continue;
            }
            if(dfs(neigh,node,visited,adj)){
                return true;
            }
        }
        return false;
    }
}

/*
Time complexity: O(E∗(V+E))
Space complexity: O(V+E)
  */
