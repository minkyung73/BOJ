package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1759_2 {
    // 암호 만들기
    static StringBuilder sb = new StringBuilder();
    static int l, c;
    static String[] arr, sel;


    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < c; i++) {
            bt(i, arr[i]);
        }
        System.out.println(sb);
    }

    public static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new String[c];
        sel = new String[l];

        for(int i=0 ; i<c ; i++)
            arr[i] = st.nextToken();
        Arrays.sort(arr);
    }

    public static void bt(int idx, String str) {
        // basis part
        if(idx == c) {
            return ;
        }

        if(str.length() == l) {
            // checkAEIOU
            if(checkAEIOU(str))
                sb.append(str).append("\n");
            return ;
        }

        // inductive part
        for(int i=idx+1 ; i<c ; i++) {
            bt(i, str + arr[i]);
        }
    }

    private static boolean checkAEIOU(String str) {
        String[] aeiou = {"a", "e", "i", "o", "u"};
        int cnt = 0;	// 모음 체크

        for(String c : aeiou) {
            if(str.contains(c)) cnt++;
        }

        if(cnt >= 1 && str.length() - cnt >=2) return true;
        return false;
    }
}
