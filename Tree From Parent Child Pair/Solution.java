// int[][] pairs = {
//     {1, 2},
//     {1, 3},
//     {3, 4},
//     {3, 5}
// };

//         1
//       /   \
//      2     3
//          / \
//         4   5


import java.text.ListFormat.Style;
import java.util.*;
class TreeNode{
  int val;
  List<TreeNode>children=new ArrayList<>();

  TreeNode(int val){
    this.val=val;
  }
}
public class Solution {
  static int maxDiff = Integer.MIN_VALUE;
    static Map<Integer, Integer> costMap;
  public static void main(String[] args){
    int [][]pairs= {
            {1, 2},
            {1, 3},
            {3, 4},
            {3, 5}
        };

        costMap = new HashMap<>();
        costMap.put(1, 10);
        costMap.put(2, 5);
        costMap.put(3, 8);
        costMap.put(4, 1);
        costMap.put(5, 7);
    TreeNode root=buildTree(pairs);
    printTree(root);
     dfs(root, costMap.get(root.val));
        System.out.println("Max Ancestor-Descendant Cost Difference: " + maxDiff);
  }
  public static TreeNode buildTree(int [][]pairs){
    Set<Integer>allChildren=new HashSet<>();
    Set<Integer>allNode=new HashSet<>();
    Map<Integer,List<Integer>>treeMap=new HashMap<>();

    // build parent -> children map and track all children
    for(int [] pair : pairs){
      int parent= pair[0];
      int child= pair[1];

      treeMap.computeIfAbsent(parent,k->new ArrayList<>()).add(child);
      allChildren.add(child);
      allNode.add(parent);
      allNode.add(child);
    }

    int rootVal=-1;
    for(int node:allNode){
      if(!allChildren.contains(node)){
        rootVal=node;
        break;
      }
    }
    if(rootVal==-1)return null;

    return buildNode(rootVal,treeMap);
  }

  private static TreeNode buildNode(int val,Map<Integer,List<Integer>>map){
    TreeNode node=new TreeNode(val);
    
    if(map.containsKey(val)){
      for(int childVal:map.get(val)){
        node.children.add(buildNode(childVal, map));
      }
    }


    return node;
  }
  public static void printTree(TreeNode node){
    if(node==null)return;

    System.out.print(node.val+" -> [");
    for(int i=0;i<node.children.size();i++){
      System.out.print(node.children.get(i).val);
      if(i<node.children.size()-1){
        System.err.print(", ");
      }
    }
    System.out.println("]");
    for(TreeNode child:node.children){
      printTree(child);
    }
  }
  public static void dfs(TreeNode node,int ancestorCost){
    if(node==null)return;

    int currCost=costMap.get(node.val);
    maxDiff=Math.max(maxDiff,ancestorCost-currCost);
    for(TreeNode child:node.children){
      dfs(child,ancestorCost);
    }
    for(TreeNode child:node.children){
      dfs(child, costMap.get(node.val));
    }
  }
 
}


// without tree
import java.util.*;

public class MaxCostDifferenceSimple {

    static int maxDiff = Integer.MIN_VALUE;
    static Map<Integer, Integer> costMap = new HashMap<>();
    static Map<Integer, List<Integer>> adj = new HashMap<>();

    public static void main(String[] args) {
        int[][] pairs = {
            {1, 2},
            {1, 3},
            {3, 4},
            {3, 5}
        };

        // Cost of each node
        costMap.put(1, 10);
        costMap.put(2, 5);
        costMap.put(3, 8);
        costMap.put(4, 1);
        costMap.put(5, 7);

        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> childNodes = new HashSet<>();

        // Build adjacency list
        for (int[] pair : pairs) {
            int parent = pair[0];
            int child = pair[1];
            adj.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);

            allNodes.add(parent);
            allNodes.add(child);
            childNodes.add(child);
        }

        // Find the root (node not in child set)
        int root = -1;
        for (int node : allNodes) {
            if (!childNodes.contains(node)) {
                root = node;
                break;
            }
        }

        if (root == -1) {
            System.out.println("No valid root found.");
            return;
        }

        // Start DFS
        dfs(root, costMap.get(root));

        System.out.println("Max Ancestor-Descendant Cost Difference: " + maxDiff);
    }

    public static void dfs(int node, int maxAncestorCost) {
        int currCost = costMap.get(node);
        maxDiff = Math.max(maxDiff, maxAncestorCost - currCost);

        if (adj.containsKey(node)) {
            for (int child : adj.get(node)) {
                // Pass down the max of current ancestor and current node
                dfs(child, Math.max(maxAncestorCost, currCost));
            }
        }
    }
}
