#include <bits/stdc++.h>
#define ll long long
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    ll n;
    cin >> n ;
    ll s=0;
    for(int i=1;i<n;++i){
        ll a;
        cin >> a;
        s+=a;
    }
    cout << (n*(n+1))/2 -s;
    
}
