import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1181 {
    // 단어 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];
        for(int i=0 ; i<n ; i++) words[i] = br.readLine();

        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length())
                    return s1.compareTo(s2);
                else
                    return s1.length() - s2.length();
            }
        });

        System.out.println(words[0]);
        for(int i=1 ; i<n ; i++) {
            if(!words[i].equals(words[i-1]))    // 중복 문자열일 경우 출력 X
                System.out.println(words[i]);
        }
    }
}
