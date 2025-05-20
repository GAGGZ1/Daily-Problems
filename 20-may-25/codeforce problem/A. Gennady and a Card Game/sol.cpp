#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main(){
  string s;
  cin>>s;
  string arr[5];
  for(int i=0;i<5;i++){
    cin>>arr[i];
    }

    bool flag=false;
    for(int i=0;i<5;i++){
      char f=s[0];
      char ss=s[1];
      char af=arr[i][0];
      char as=arr[i][1];

      if(f==af || ss==as){
        flag=true;
      }


    }
    if(flag){
      cout<<"YES"<<'\n';
    }
    else{
      cout<<"NO"<<'\n';
    }
  return 0;
}