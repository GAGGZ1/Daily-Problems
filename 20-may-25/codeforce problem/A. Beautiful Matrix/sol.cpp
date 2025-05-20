#include<iostream>
#include<bits/stdc++.h>
using namespace std;

int main(){
  int m=5;
  int n=5;
  int mat[m][n];
  int ci=0;
  int cj=0;
  for(int i=0;i<m;i++){
    for(int j=0;j<n;j++){
     cin>> mat[i][j];
     if(mat[i][j]==1){
      ci=i;
      cj=j;
     }
    }
  }
  int sum=abs(2-ci);
  sum+=abs(2-cj);
  cout<<sum<<'\n';
  
  return 0;
}
