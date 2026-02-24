class Solution {
    private Map<Integer,List<Integer>> preMap=new HashMap<>();

    private Set<Integer> visited=new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i=0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>());
        }

        for(int[] pre:prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int i=0;i<numCourses;i++){
            if(!dfs(i)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int crs){
        if(visited.contains(crs)){
            return false;
        }

        if(preMap.get(crs).isEmpty()){
            return true;
        }

        visited.add(crs);
        for(int precrs:preMap.get(crs)){
            if(!dfs(precrs)){
                return false;
            }
        }

        visited.remove(crs);
        preMap.put(crs,new ArrayList<>());
        return true;
    }
}

/*
Time complexity: (V+E)
Space complexity: O(V+E)
*/
