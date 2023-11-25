package boj.bronze._2;

import java.util.Scanner;

public class boj_2675 {
    public static void main(String[] args){
//        문자열 반복
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[] iter = new int[num];
        String[] strings = new String[num];

        for(int i=0 ; i<num ; i++){
            iter[i] = sc.nextInt();
            strings[i] = sc.next();
        }

        for(int i=0 ; i<num ; i++){
            char[] chars = strings[i].toCharArray();

            for(char ch : chars){
                for(int j=0 ; j<iter[i] ; j++)
                    System.out.print(ch);
            }
            System.out.println();
        }
    }
}
