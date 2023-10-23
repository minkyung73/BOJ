package boj;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj_2562 {
    public static void main(String[] args){
//        최댓값
        Scanner scanner = new Scanner(System.in);

        int[] num = new int[9];
        int max = -1;
        int maxi = -1;

        for(int i=0 ; i<9 ; i++){
            num[i] = scanner.nextInt();

            if(num[i] > max){
                max = num[i];
                maxi = i+1;
            }
        }

        System.out.println(max);
        System.out.println(maxi);
    }
}
