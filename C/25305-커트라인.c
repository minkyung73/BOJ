// bronze II
#include <stdio.h>

void bubble_sort(int arr[], int n){
    int temp;
    for(int i=n-1 ; i>0 ; i--){
        for(int j=0 ; j<i ; j++){
            if(arr[j] < arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
}

int main()
{
    int n, k, arr[1000];
    scanf("%d %d ", &n, &k);
    for(int i=0 ; i<n ; i++)
        scanf("%d", &arr[i]);

    bubble_sort(arr, n);

    printf("%d", arr[k-1]);
}

