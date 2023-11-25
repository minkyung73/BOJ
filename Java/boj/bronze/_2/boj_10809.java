package boj.bronze._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10809 {
    // 알파벳 찾기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = new int[26];
        for(int i=0 ; i<26 ; i++) arr[i] = -1;

        for(int i=0 ; i<str.length() ; i++) {
            int idx = (int)str.charAt(i) - 97;
            if(arr[idx] == -1) arr[idx] = i;
        }

        for(int i=0 ; i<26 ; i++) System.out.print(arr[i] + " ");
    }
}
