package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_18662 {
    // 등차수열 만들기
    private static int[] n = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0 ; j<3 ; j++) n[j] = Integer.parseInt(st.nextToken());
            sb.append("#" + (i+1) + " " + f() + "\n");
        }
        System.out.println(sb);
    }

    public static double f() {
        double temp = Math.round((double)(n[0] + n[2])/2 * 10)/10.0;
        return Math.abs(temp-n[1]);
    }
}
