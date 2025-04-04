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
typedef pair<int,int> pi; 
typedef vector<pi>vpi;



int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
    string s;
    cin >> s;
    int ans=1;
    int c=0;
    char l=s[0];
    
    for(char d:s){
        if(l==d){
            ++c;
            ans=max(c,ans);
        }
        else{
            l=d;
            c=1;
        }
    }
    cout << ans << '\n';
	return 0;

}
