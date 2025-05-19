#include<iostream>
#include<bits/stdc++.h>
using namespace std;

bool inc(string s){
  if(s=="++X" || s=="X++"){
    return true;
  }
  return false;
}

int main(){
  int n;
  cin>>n;
  int x=0;
  while(n-->0){
    string s;
    cin>>s;
    if(inc(s)){
      x++;
    }
    else{
      x--;
    }
  }
  cout<<x<<'\n';

  return 0;
}