package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class swea_17642 {
    // 최대 조작 횟수
    private static long a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());

            // function call
            sb.append("#" + (i+1) + " " + maxOper(a, b) + "\n");
        }
        System.out.println(sb);
    }

    public static long maxOper(long A0, long B0) {
        if (A0 == B0) {
            return 0;
        }else if(A0 > B0) {
            return -1;
        }

        long diff = Math.abs(A0 - B0);

        if (diff == 1) {
            return -1; // 차이가 1인경우 불가능.
        } else if(diff % 2 == 1){
            return ((diff - 1) / 2) ;
        } else {
            return (diff/2);
        }

    }
}
