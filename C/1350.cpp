#include <iostream>
#include <vector>

using namespace std;

int main()
{
    vector<int> chk(30, 0);
    int num;

    for(int i=0 ; i<28 ; i++) {
        cin >> num;
        chk[num-1] = 1;
    }

    for(int i=0 ; i<30 ; i++) {
        if(chk[i] == 0)
            cout << i+1 << endl;
    }
}