class Solution {
    public boolean isValidSudoku(char[][] b) {
        for(int i=0;i<b.length;i++){
            for(int j=0;j<b[0].length;j++){
                if(b[i][j]!='.' && !safe(b,b[i][j],i,j)){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean safe(char[][]b,char ch,int r,int c){
        // 1. row
        for(int j=0;j<b[0].length;j++){
           if(j!=c && b[r][j]==ch){
            return false;
           }
        }
        // 2. col

        for(int i=0;i<b.length;i++){
            if(i!=r && b[i][c]==ch){
                return false;
            }
        }
        // 3. 3x3
        int newr=r-r%3;
        int newc=c-c%3;
        for(int i=newr;i<newr+3;i++){
            for(int j=newc;j<newc+3;j++){
                if(i!=r && j!=c){
                    if(b[i][j]==ch)return false;
                }
            }
        }

        return true;
    }
}