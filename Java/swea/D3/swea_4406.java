package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class swea_4406 {
    // 모음이 보이지 않는 사람
    private static List<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            String str = br.readLine();
            sb.append("#" + (i+1) + " " + f(str) + "\n");
        }
        System.out.println(sb);
    }

    public static String f(String str) {
        String result = str;

        for(int i=0 ; i<str.length() ; i++) {
            if(vowel.contains(str.charAt(i))) {
                result = result.replace(String.valueOf(str.charAt(i)), "");
            }
        }

        return result;
    }
}
