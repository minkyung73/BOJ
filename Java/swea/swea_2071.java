package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_2071 {
    // 평균값 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            for(int j=0 ; j<10 ; j++)
                sum += Integer.parseInt(st.nextToken());

            double avg = Math.round((double) sum/10);
            sb.append("#" + (i+1) + " " + (int) avg + "\n");
        }

        System.out.println(sb);
    }
}
