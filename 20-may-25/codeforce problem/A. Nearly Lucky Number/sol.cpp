#include <iostream>
#include <string>
using namespace std;

int main() {
    string n;
    cin >> n;

    int luckyCount = 0;
    for (char ch : n) {
        if (ch == '4' || ch == '7') {
            luckyCount++;
        }
    }

    string countStr = to_string(luckyCount);
    bool isLucky = true;
    for (char ch : countStr) {
        if (ch != '4' && ch != '7') {
            isLucky = false;
            break;
        }
    }

    if (isLucky && luckyCount > 0) {
        cout << "YES" << '\n';
    } else {
        cout << "NO" << '\n';
    }

    return 0;
}
