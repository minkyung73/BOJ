#include <stdio.h>

int main()
{
    int arr[10][10];

    for(int i=0 ; i<10 ; i++) {
        for(int j=0 ; j<10 ; j++) {
            scanf("%d ", &arr[i][j]);
        }
    }

    int x = 1, y = 1, flag = 0;

    while (1)
    {
        if(arr[x][y] == 2) break;
        else arr[x][y] = 9;
        
        // 오른쪽으로 이동하는 경우
        if(x+1 < 10 && arr[x+1][y] == 0) {
            x++;
            continue;
        }
        // 아래로 이동하는 경우
        else if (x + 1 >= 10 || (x+1 < 10 && arr[x+1][y] == 1)) {
            if(y+1 < 10) {
                y++;
                continue;
            }
            else {
                flag = 1;
                break;
            }
        }
    }
    


}