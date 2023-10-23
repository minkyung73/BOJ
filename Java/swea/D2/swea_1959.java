package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1959 {
    // 두 개의 숫자열
    private static int n, m;
    private static int[] nArr, mArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            nArr = new int[n];
            mArr = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++)
                nArr[j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<m ; j++)
                mArr[j] = Integer.parseInt(st.nextToken());

            sb.append("#" + (i+1) + " " + sliding() + "\n");
        }
        System.out.println(sb);
    }

    public static int sliding() {
        int result = 0;

        int big = Math.max(n, m);
        int small = Math.min(n, m);
        int[] bArr = n > m ? nArr.clone() : mArr.clone();
        int[] sArr = n < m ? nArr.clone() : mArr.clone();

        for(int i=0 ; i<big - small + 1 ; i++) {
            int temp = 0;
            for(int j=0 ; j<small ; j++) {
                temp += sArr[j] * bArr[i+j];
            }

            result = Math.max(temp, result);
        }

        return result;
    }
}
