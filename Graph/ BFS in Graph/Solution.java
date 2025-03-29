import java.util.*;

public class Solution {

    public static List<Integer> bfsTraversal(int n, List<List<Integer>> adj){

        List<Integer>ans = new ArrayList<>();

        boolean[] visited = new boolean[n];

        Queue<Integer>q = new LinkedList<>();

        q.add(0);

        visited[0] = true;

        while(q.isEmpty()!=true){

            int top = q.poll();

            ans.add(top);

            for(int child:adj.get(top)){

                if(visited[child]==false){

                    q.add(child);

                    visited[child] = true;

                }

            }

        }

        return ans;

    }

}