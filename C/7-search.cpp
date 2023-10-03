#include <stdio.h>
#include <algorithm>

using namespace std;

/*
int main()
{
    int n, k, ar[1001], i;
    scanf("%d", &n);

    for(i=0 ; i<n ; i++) {
        scanf("%d", ar+i);
    }
    scanf("%d", &k);

    printf("%d\n", lower_bound(ar, ar+n, k)-ar);
    printf("%d\n", upper_bound(ar, ar+n, k)-ar);
    
    return 0;
}
*/

int comp(const void *a, const void *b)
{
    return (*(int*)a - *(int*)b);
}

int main()
{
    int ar[] = {1, 4, 5, 7, 9, 10, 12, 19, 25, 30};
    int key, *loc;
    for(int i=0 ; i<10 ; i++)
        printf("%d ", ar[i]);
    printf("\n");
    printf("search: ");
    scanf("%d", &key);

    loc = (int*)bsearch(&key, ar, 10, sizeof(int), comp);

    if(loc)
        printf("%d번째 data: %d 존재", int(loc-ar)+1, key);
    else
        printf("data: %d 존재하지 않음", key);

}