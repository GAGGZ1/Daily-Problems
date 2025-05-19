#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main(){
  int t;
  cin>>t;

  while(t-->0){
    int n;
    cin>>n;
    string s;
    cin>>s;
    int first=-1;
    int last=-1;
    bool flag=false;
    for(int i=0;i<n;i++){
      if(s[i]=='1'){
        last=i;
        
      }
      if(s[i]=='1' && !flag){
        first=i;flag=true;
      }
    }
    int currmax=n;
    // cout<<"first="<<first<<"\n";
    
    int frf=(n-first)*2;
    // cout<<"frf="<<frf<<"\n";
    if(first==-1)frf=0;
    if(last!=-1){
    if(currmax<((last+1)*2)){
      currmax=(last+1)*2;
    }}
    if(currmax<frf){
      currmax=frf;
    }
    cout<<currmax<<'\n';
  }
  return 0;
}