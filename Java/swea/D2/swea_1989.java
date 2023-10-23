package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea_1989 {
    // 초심자의 회문 검사

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            String str = br.readLine();
            int result = palindrome(str);
            sb.append("#" + (i+1) + " " + result + "\n");
        }

        System.out.print(sb);
    }

    public static int palindrome(String str) {
        for(int i=0 ; i<str.length()/2 ; i++) {
            if(str.charAt(i) != str.charAt(str.length()-i-1))
                return 0;
        }

        return 1;
    }
}
