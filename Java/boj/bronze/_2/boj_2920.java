package boj.bronze._2;

import java.util.Scanner;

public class boj_2920 {
    public static void main(String[] args){
//        음계
        Scanner sc = new Scanner(System.in);

        // 입력
        int[] num = new int[8];
        for(int i=0 ; i<8 ; i++)
            num[i] = sc.nextInt();

        // 첫 음계
        String result = "";
        int flag = 0;
        if(num[0] == 1){
            flag = 0;
            result = "ascending";
        }
        else if(num[0] == 8){
            flag = 2;
            result = "descending";
        }
        else{
            flag = 1;
            result = "mixed";
        }

        int i = 1;
        while(flag != 1 && i<8){
            if(flag == 0){
                if(num[i] != num[i-1] + 1){
                    result = "mixed";
                    flag = 1;
                }
            }
            else if(flag == 2){
                if(num[i] != num[i-1] - 1)
                {
                    result = "mixed";
                    flag = 1;
                }
            }

            i++;
        }

        System.out.println(result);
    }
}
