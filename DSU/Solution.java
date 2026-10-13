class DSU {
  int[] parent;
  int[] size;

  DSU(int n){
    parent =new int[n];
    size=new int[n];

    for(int i=0;i<n;i++){
      parent[i]=i;
      size[i]=1;
    }

  }
  int find(int x){
    if(parent[x]!=x){
      parent[x]=find(parent[x]);
    }
    return parent[x];
  }
  void union(int a, int b){
    int rootA=find(a);
    int rootB=find(b);

    //if already in same grp

    if(rootA==rootB){
      return;
    }
    // smaller tree goes below larger tree
    if(size[rootA]<size[rootB]){
      int temp=rootA;
      rootA=rootB;
      rootB=temp;
    }
    parent[rootB]=rootA;
    size[rootA]+=size[rootB];est

  }
}
