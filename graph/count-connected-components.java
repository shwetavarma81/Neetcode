class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj=new ArrayList<>();
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        int components=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,adj,visited);
                components++;
            }
        }

        return components;
    }

    private void dfs(int node,List<List<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int neigh:adj.get(node)){
            if(!visited[neigh]){
                dfs(neigh,adj,visited);
            }
        }
    }
}

/*
Time complexity: O(V+E)
Space complexity: O(V+E)
  */
