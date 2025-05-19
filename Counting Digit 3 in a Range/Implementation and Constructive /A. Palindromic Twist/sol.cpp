#include <iostream>
#include <cmath>
using namespace std;

bool isPalindromicTwist(const string& s) {
    int n = s.size();
    for (int i = 0; i < n / 2; i++) {
        int diff = abs(s[i] - s[n - i - 1]);
        if (diff != 0 && diff != 2) {
            return false;
        }
    }
    return true;
}

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        string s;
        cin >> s;
        cout << (isPalindromicTwist(s) ? "YES" : "NO") << endl;
    }
    return 0;
}
