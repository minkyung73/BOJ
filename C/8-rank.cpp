#include <stdio.h>

/*
int main()
{
    int a[7] = {8, 9, 10, 7, 5, 3, 4};
    int d[7], i, j;

    for(i=0 ; i<7 ; i++) d[i] = 1;

    for(i=0 ; i<7 ; i++) {
        for(j=0 ; j<7 ; j++) {
            if (i==j) continue;
            if(a[i] < a[j]) d[i]++;
        }
    }

    printf("숫자        등수\n");
    for(i=0 ; i<7 ; i++)
        printf("%4d     %3d\n", a[i], d[i]);
}
*/

int main()
{
    int a[13] = {5, 8, 9, 10, 7, 8, 5, 3, 4, 8, 1, 6, 2};
    int d[13], i, j, answer, count = 0;

    for(i=0 ; i<13 ; i++) d[i] = 1;

    for(i=0 ; i<13 ; i++) {
        for(j=0 ; j<13 ; j++) {
            if (i==j) continue;
            if(a[i] < a[j]) d[i]++;
        }
    }

    printf("숫자\t개수\n");
    for(i=0 ; i<13 ; i++){
        if(d[i] == 3) {
            answer = a[i];
            count++;
        }
    }

    printf("%d\t%d\n",answer, count);
        
}