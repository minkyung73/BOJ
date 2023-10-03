 #include <iostream>
 #include <vector>
 #include <algorithm>
 #include <utility>

 using namespace std;

/*
 int main()
 {
    vector<int> v1(5);
    vector<int> v2(5, 1);

    for(int i=0 ; i<v1.size() ; i++) 
        cout << v1[i] << " ";
    cout << endl;

    for(int i=0 ; i<v2.size() ; i++)
        cout << v2[i] << " ";

    return 0;
 }
 */

/*
int main() 
{
    vector<int> v;
    v.resize(5);

    for(int i=0 ; i<v.size() ; i++) 
        v[i] = i+1;

    for(int i=0 ; i<v.size() ; i++) 
        cout << v[i] << " ";

    return 0;
}
*/

/*
int main()
{
    vector<int> v;

    for(int i=0 ; i<5 ; i++)
        v.push_back(i+1);
    
    for(int i=0 ; i<v.size() ; i++) 
        cout << v[i] << " ";

    cout << endl;

    v.pop_back();
    v.pop_back();

    cout << v.size() << endl;

    for(int i=0 ; i<v.size() ; i++)
        cout << v[i] << " ";

    return 0;
}
*/

/*
int main()
{
    vector <int> v;
    int k;
    for(int i=0 ; i<5 ; i++) {
        cin >> k;
        v.push_back(k);
    }

    sort(v.begin(), v.end());

    for(int i = 0 ; i<v.size() ;i++)
        cout << v[i] << " ";
    cout << endl;
    
    return 0;
} 
*/

/*
int main()
{
    vector<vector<int> > arr(3, vector<int>(4, 0));

    for(int i=0 ; i<arr.size() ; i++) {
        for(int j=0 ; j<arr[i].size() ; j++) {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }

    int serial = 1;

    for(int i=0 ; i<3 ; i++) {
        for(int j=0 ; j<4 ; j++) {
            arr[i][j] = serial++;
        }
    }

    for(int i=0 ; i<arr.size() ; i++) {
        for(int j=0 ; j<arr[i].size() ; j++) {
            cout << arr[i][j] << " ";
        }
        cout << endl;
    }

    return 0;
}
*/

/*
int main() 
{
    int serial = 1;
    int n, m;
    cin >> n >> m;

    vector<vector<int> > arr;
    arr.assign(n, vector<int>(m, 0));

    for(int i=0 ; i<arr.size() ; i++) {
        for(int j=0 ; j<arr[i].size() ; j++) {
            arr[i][j] = serial++;
        }
    }

    for(int i=0 ; i<arr.size() ; i++) {
        for(int j=0 ; j<arr[i].size() ; j++) {
            cout << arr[i][j] << " ";
        }
        cout <<endl;
    }
}
*/

/*
int main()
{
    vector<pair<int, char> > v;

    v.push_back(make_pair(65, 'A'));
    v.push_back(make_pair(66, 'B'));
    v.push_back(make_pair(67, 'C'));
    v.push_back(make_pair(68, 'd'));
    v.push_back(make_pair(69, 'e'));

    for(int i=0 ; i<v.size() ; i++){
        cout << v[i].first << " ";
        cout << v[i].second << endl;
    }

    return 0;
}
*/