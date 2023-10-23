package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1976 {
    // 시각 덧셈

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int hour = h1 + h2;
            int minute = m1 + m2;

            hour += minute / 60;
            minute = minute % 60;
            hour = hour % 12 == 0 ? 12 : hour % 12;

            sb.append("#" + (i+1) + " " + hour + " " + minute + "\n");
        }
        System.out.println(sb);
    }
}
