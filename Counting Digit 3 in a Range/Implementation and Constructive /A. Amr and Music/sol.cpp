#include<iostream>
#include <bits/stdc++.h>

using namespace std;

int main(){
  int n;
  int k;
  cin>>n>>k;

  vector<int>v(n);
  for(int i=0;i<n;i++){
   
    cin>>v[i];
   
  }
  vector<pair<int,int>>vp;
  for(int i=0;i<n;i++){
    vp.push_back({v[i],i+1});
  }
  sort(vp.begin(),vp.end());
  vector<int>ans;
  for(int i=0;i<n;i++){
    if(k-vp[i].first>=0){
      ans.push_back(vp[i].second);
      k-=vp[i].first;
    }
    else{
      break;
    }
  }
  cout<<ans.size()<<'\n';
  for(int i=0;i<ans.size();i++){
    cout<<ans[i]<<" ";
  }
  cout<<"\n";

}