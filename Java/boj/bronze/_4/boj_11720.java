package boj.bronze._4;

import java.util.Scanner;

public class boj_11720 {
    public static void main(String[] args){
//        숫자의 합
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String numbers = sc.next();

        int sum = 0;

        for(int i=0 ; i<n ; i++){
            int temp = Character.getNumericValue(numbers.charAt(i));

            if(temp == 0)
                continue;
            else
                sum += temp;
        }

        System.out.println(sum);
    }
}
