class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> pre=new HashMap<>();
        for(int i=0;i<numCourses;i++){
            pre.put(i,new ArrayList<>());
        }

        for(int[] precrs:prerequisites){
            pre.get(precrs[0]).add(precrs[1]);
        }
        
        List<Integer> output=new ArrayList<>();
        Set<Integer> visited=new HashSet<>();
        Set<Integer> cycle=new HashSet<>();

        for(int i=0;i<numCourses;i++){
            if(!dfs(i,pre,output,visited,cycle)){
                return new int[0];
            }
        }

        int[] result=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            result[i]=output.get(i);
        }

        return result;
    }

    private boolean dfs(int crs,Map<Integer,List<Integer>> pre,List<Integer> output,Set<Integer> visited,Set<Integer> cycle){
        if(cycle.contains(crs)){
            return false;
        }
        if(visited.contains(crs)){
            return true;
        }
        cycle.add(crs);
        for(int precrs:pre.getOrDefault(crs,Collections.emptyList())){
            if(!dfs(precrs,pre,output,visited,cycle)){
                return false;
            }
        }
        visited.add(crs);
        cycle.remove(crs);
        output.add(crs);
        return true;
    }
}

/*
Time complexity: O(V+E)
Space complexity: O(V+E)
*/
