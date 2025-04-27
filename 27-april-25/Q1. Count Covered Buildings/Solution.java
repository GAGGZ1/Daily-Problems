class Solution {
  public int countCoveredBuildings(int n,int[][] bb) {
      ArrayList<Integer>l=new ArrayList<>(Collections.nCopies(n+1,n+1));
      ArrayList<Integer>r=new ArrayList<>(Collections.nCopies(n+1,-1));
      ArrayList<Integer>t=new ArrayList<>(Collections.nCopies(n+1,n+1));
      ArrayList<Integer>btm=new ArrayList<>(Collections.nCopies(n+1,-1));
      pb(bb,l,r,t,btm);
      int count=0;
      for (int[]b:bb) {
          int x=b[0],y=b[1];
          boolean isVert = ver(x,y,l,r);
          boolean isHori=hori(x,y,t,btm);
          if (isVert && isHori) {
              count++;
          }
      }

      return count;
  }

  public void pb(int[][] bb,ArrayList<Integer>l,ArrayList<Integer>r,
          ArrayList<Integer>t,ArrayList<Integer>btm) {
      for (int[]b:bb) {
          int x=b[0],y=b[1];
          l.set(x,Math.min(l.get(x),y));
          r.set(x,Math.max(r.get(x),y));
          t.set(y,Math.min(t.get(y),x));
          btm.set(y,Math.max(btm.get(y),x));
      }
  }

  public boolean ver(int x,int y,ArrayList<Integer>l,ArrayList<Integer>r){
      return(l.get(x)<y&&r.get(x)>y);
  }

  public boolean hori(int x,int y,ArrayList<Integer>t,ArrayList<Integer>btm){
      return(t.get(y)<x && btm.get(y)>x);
  }
}
