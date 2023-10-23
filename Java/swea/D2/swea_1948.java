package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1948 {
    // 날짜 계산기
    private static int m1, m2, d1, d2;
    private static int[] finalDay = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            m1 = Integer.parseInt(st.nextToken());
            d1 = Integer.parseInt(st.nextToken());
            m2 = Integer.parseInt(st.nextToken());
            d2 = Integer.parseInt(st.nextToken());

            sb.append("#" + (i+1) + " " + countDay() + "\n");
        }
        System.out.println(sb);
    }

    public static int countDay() {
        int cnt = 0;

        for(int i=m1 ; i<=m2 ; i++) {
            if(m1 == m2) return d2 - d1 + 1;

            if(i == m1)
                cnt += finalDay[i-1] - d1 + 1;
            else if(i == m2)
                cnt += d2;
            else
                cnt += finalDay[i-1];
        }

        return cnt;
    }
}
