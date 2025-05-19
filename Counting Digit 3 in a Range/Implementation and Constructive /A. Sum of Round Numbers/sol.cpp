#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main()
{
  int t;
  cin>>t;
  while(t-->0)
  {
    int n;
    cin>>n;
    vector<int>v;
    int i=1;
    while(n>0){
    int num=n%10;
      if(num!=0){
        v.push_back(num*i);
      }
    n/=10;
      i=i*10;
    }
    cout<<v.size()<<'\n';
    for(int it:v){
      cout<<it<<" ";
    }
    cout<<"\n";
    
  }
  return 0;
}