package swea.D1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2050 {
    // 알파벳을 숫자로 변환

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(int i=0 ; i<str.length() ; i++) {
            int c = str.charAt(i);

            if(c >= 65 && c <= 90) sb.append(c-64 + " ");
            else if(c >= 97 && c <= 122) sb.append(c-96 + " ");
        }

        System.out.println(sb);
    }
}
