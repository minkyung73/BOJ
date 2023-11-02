package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_10505 {
    // 소득 불균형

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            int sum = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                sum += arr[j];
            }

            double avg = (double) sum / n;
            Arrays.sort(arr);
            int cnt = 0;
            for(int j=0 ;j<n ; j++) {
                if(arr[j] <= avg) cnt++;
                else break;
            }

            sb.append("#" + (i+1) + " " + cnt + "\n");
        }
        System.out.println(sb);
    }
}
