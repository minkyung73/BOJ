package boj;

import java.util.Scanner;

public class boj_2475 {
    public static void main(String[] args){
//        검증수
        Scanner sc = new Scanner(System.in);

        int[] num = new int[5];
        for(int i=0 ; i<5 ; i++){
            num[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i=0 ; i<5 ; i++){
            if(num[i] == 0)
                continue;

            sum += Math.pow(num[i], 2);
        }

        System.out.println(sum%10);
    }
}
