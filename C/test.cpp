#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main()
{
    int n, k;
    vector<int> v;

    cin >> n;
    for(int i=0 ; i<n ; i++) {
        cin >> k;
        v.push_back(k);
    }

    sort(v.begin(), v.end(), greater<>());

    for(int i=0 ; i<n ;i++) {
        cout << v[i] << " ";
    }
}