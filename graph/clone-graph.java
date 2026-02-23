/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node,Node> clone=new HashMap<>();

        return dfs(node,clone);
    }

    private Node dfs(Node node, Map<Node,Node> clone){
        if(node==null){
            return null;
        }

        if(clone.containsKey(node)){
            return clone.get(node);
        }

        Node copy=new Node(node.val);
        clone.put(node,copy);

        for(Node n:node.neighbors){
            copy.neighbors.add(dfs(n,clone));
        }

        return copy;
    }

/*
Time complexity: O(V+E)
Space complexity: O(V)
*/
}
