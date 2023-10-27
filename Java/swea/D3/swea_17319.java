package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class swea_17319 {
    // 문자열문자열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();

            String s1 = str.substring(0, len/2);
            String s2 = str.substring(len/2);

            if(s1.equals(s2)) sb.append("#" + (i+1) + " Yes\n");
            else sb.append("#" + (i+1) + " No\n");
        }
        System.out.println(sb);
    }
}
