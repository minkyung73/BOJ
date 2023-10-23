package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1984 {
    // 중간 평균값 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            int min = 10000, max = 0, sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<10 ; j++) {
                int num = Integer.parseInt(st.nextToken());

                if(num < min) min = num;
                if(num > max) max = num;
                sum += num;
            }
            sum = sum - min - max;
            double avg = Math.round((double) sum/8);
            sb.append("#" + (i+1) + " " + (int) avg + "\n");
        }
        System.out.println(sb);
    }
}
