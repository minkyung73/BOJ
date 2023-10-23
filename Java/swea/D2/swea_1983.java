package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_1983 {
    // 조교의 성적 매기기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int rank = 0;
            double k_score;
            double[] arr = new double[n];

            for(int j=0 ; j<n ; j++) {
                st = new StringTokenizer(br.readLine());
                double n1 = Double.parseDouble(st.nextToken());
                double n2 = Double.parseDouble(st.nextToken());
                double n3 = Double.parseDouble(st.nextToken());

                arr[j] = Math.round((n1*0.35 + n2*0.45 + n3*0.2)*100)/100.0;
            }

            k_score = arr[k-1];
            for(int j=0 ; j<n ; j++) {
                if(k == j+1) continue;

                if(arr[j] > k_score) rank++;
            }

            sb.append("#" + (i+1) + " " + grade[rank/(n/10)] + "\n");
        }
        System.out.print(sb);
    }
}
