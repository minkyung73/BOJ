package boj.bronze._5;

import java.util.Scanner;

public class boj_27866 {
    public static void main(String[] args){
//        문자와 문자열
        Scanner sc = new Scanner(System.in);

        String S = sc.nextLine();
        int i = sc.nextInt();

        System.out.println(S.charAt(i-1));
    }
}
