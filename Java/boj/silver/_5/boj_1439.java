package boj.silver._5;

import java.util.Scanner;

public class boj_1439 {
    public static void main(String[] args) {
        // 뒤집기

        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        int cnt0 = 0;
        int cnt1 = 0;

        char[] chars = S.toCharArray();

        if(chars[0] == '0') cnt0++;
        else if(chars[0] == '1') cnt1++;

        for(int i=1 ; i<S.length() ; i++) {
            if(chars[i] != chars[i-1]) {
                if(chars[i] == '0') cnt0++;
                else if(chars[i] == '1') cnt1++;
            }
        }


        System.out.println(Math.min(cnt0, cnt1));






    }
}
