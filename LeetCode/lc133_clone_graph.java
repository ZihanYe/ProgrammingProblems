// Leetcode 133. Clone Graph
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> mp = new HashMap<>();
        return dfs(node, mp); 
    }
    
    UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> mp){
        if (node != null){
            UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
            mp.put(node.label, newNode);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!mp.containsKey(neighbor.label))
                    newNode.neighbors.add(dfs(neighbor, mp));
                else newNode.neighbors.add(mp.get(neighbor.label));
            }
            return newNode;
        }
        return null;
    }
}