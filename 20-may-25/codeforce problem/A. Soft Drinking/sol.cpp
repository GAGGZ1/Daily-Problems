// have:
// n friends 3
// k bottles 4 
// l  water 5 
// c limes 10
// d slices 8
// p salt 100

// need:
// nl water; 3
// np salt
// 1 lime slice 1

// 5*4>3
// 100>1
// 10*8>1

// (20)/3 (100)/3 (80/3)

#include <iostream>
#include<bits/stdc++.h>
using namespace std;
int main(){
  int n;
  int k;
  int l;
  int c;
  int d;
  int p;
  int nl;
  int np;

  cin>>n>>k>>l>>c>>d>>p>>nl>>np;

  int tw=(k*l)/nl;
  int lime=c*d;
  int s=p/np;
  int ansm=min(min(tw,lime),s);
  cout<<(ansm/n)<<'\n';

  return 0;
}



