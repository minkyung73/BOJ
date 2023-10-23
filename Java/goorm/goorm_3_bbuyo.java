package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class goorm_3_bbuyo {

    private static int n, m;
    private static String str;

    public static boolean bbuyo() {

        int cnt = 0, i_idx = 0, j_idx = 0, size = str.length();
        boolean res = true;

        // 지울 알파벳 있나 확인하기
        for (int i=0 ; i<= str.length()-m ; i++) {
            cnt = 1;
            i_idx = i;
            for(int j= i+1 ; j < str.length() ; j++) {
                if(str.charAt(i) != str.charAt(j)) {
                    j_idx = j;
                    break;
                }
                cnt++;
            }

            if(cnt >= m) {
                break;
            }
        }

        if(i_idx == str.length()-m && cnt < m) return false;
        // 글자 지우기
        if(i_idx == 0) {
            str = "";
            return false;
        }
        else str = str.substring(0, i_idx) + str.substring(j_idx);

        return res;
    }

    public static void main(String[] args) throws IOException {
        // 뿌요뿌요

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        str = br.readLine();

        while (true) {
            if(!bbuyo()) break;
        }

        if(str.isEmpty()) System.out.println("CLEAR!");
        else System.out.println(str);
    }
}
