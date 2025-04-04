#include <bits/stdc++.h>
#define ll long long

#define F first
#define S second
#define PB push_back
#define MP make_pair
#define REP(i,a,b) for (int i = a; i <= b; i++)
#define SQ(a) (a)*(a)
using namespace std;
typedef vector<int> vi;
typedef vector<long long> vl;
typedef pair<int,int> pi; 
typedef vector<pi>vpi;



int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
   
    ll n;
    cin >> n;
     vl v(n);
     for(int i=0;i<n;i++){
         cin >> v[i];
     }
     ll ans=0;
     for(int i=1;i<n;i++){
         if(v[i]<v[i-1]){
             ans+=v[i-1]-v[i];
             v[i]=v[i-1];
         }
     }
    
    cout << ans << "\n";
	return 0;

}
