
class Solution {
    // Function to find all possible paths
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String>res=new ArrayList<>();
        int n=maze.length;
        boolean[][]vis=new boolean[n][n];
        StringBuilder curr=new StringBuilder();
        if (maze[0][0] == 1) { 
            vis[0][0] = true;
            solve(maze, 0, 0, res, curr, n, vis);
        }
        Collections.sort(res);
        return res;
        
    }
    public void solve(int[][]maze,int i,int j,ArrayList<String> res,StringBuilder curr,int n,boolean[][]vis){
        if(i==n-1 && j==n-1){
            res.add(new String(curr.toString()));
            return ;
        }
    
        int dirx[]={-1,1,0,0};
        int diry[]={0,0,-1,1};
        String dir="UDLR";
        
        
        
        for(int k=0;k<4;k++){
            int newx=i+dirx[k];
            int newy=j+diry[k];
            
            if(newx>=0 && newx<n && newy>=0 && newy<n && !vis[newx][newy] && maze[newx][newy]==1){
                curr.append(dir.charAt(k));
                vis[newx][newy]=true;
                solve(maze,newx,newy,res,curr,n,vis);
                curr.setLength(curr.length()-1);
                vis[newx][newy]=false;
            }
        }
        
        
    }
}