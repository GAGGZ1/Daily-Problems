#include<iostream>
#include<bits/stdc++.h>
using namespace std;
int main()
{
  int x;
  int y;
  int z;
  cin>>x>>y>>z;
  int arr[3] = {x, y, z};
  sort(arr,arr+3);
  int d1=arr[1]-arr[0];
  int d2=arr[2]-arr[1];
  cout<<d1+d2<<"\n";
  return 0;
}