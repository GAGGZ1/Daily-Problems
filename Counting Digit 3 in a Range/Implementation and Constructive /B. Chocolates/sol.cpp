#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    int n;
    cin >> n;
    vector<int> v;
    for(int i = 0; i < n; i++){
        int t;
        cin >> t;
        v.push_back(t);
    }

    vector<int> ans;
    int cmax = v[n - 1];
    cmax = max(0, cmax);
    long long sum = 0;

    for(int i = n - 1; i >= 0; i--){
        if(v[i] > cmax){
            ans.push_back(cmax);
            sum += cmax;
            cmax = max(0, cmax - 1);
        } else {
            ans.push_back(v[i]);
            sum += v[i];
            cmax = max(0, v[i] - 1);
        }
    }

    cout << sum << '\n';
    return 0;
}
