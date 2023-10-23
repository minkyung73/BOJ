package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1979 {
    // 어디에 단어가 들어갈 수 있을까
    private static int n, k;
    private static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][n];

            for(int j=0 ; j<n ; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0 ; k<n ; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            //
            int answer = width() + length();
            sb.append("#" + (i+1) + " " + answer + "\n");
        }
        System.out.print(sb);
    }

    public static boolean check(int cnt) {
        return cnt == k;
    }

    public static int width() {
        int cnt, result = 0;
        boolean isChecked;

        for(int i=0 ; i<n ; i++) {
            cnt = 0;
            isChecked = false;

            for(int j=0 ; j<n ; j++) {
                if(arr[i][j] == 1) {
                    cnt++;
                    if(isChecked) isChecked = false;
                }
                else if(arr[i][j] == 0 && cnt != 0) {
                    if(check(cnt)) {
                        isChecked = true;
                        result++;
                    }
                    cnt = 0;
                }
            }
            if(!isChecked && check(cnt)) result++;
        }

        return result;
    }

    public static int length() {
        int cnt, result = 0;
        boolean isChecked;

        for(int i=0 ; i<n ; i++) {
            cnt = 0;
            isChecked = false;

            for(int j=0 ; j<n ; j++) {
                if(arr[j][i] == 1) {
                    cnt++;
                    if(isChecked) isChecked = false;
                }
                else if(arr[j][i] == 0 && cnt != 0) {
                    if(check(cnt)) {
                        isChecked = true;
                        result++;
                    }
                    cnt = 0;
                }
            }
            if(!isChecked && check(cnt)) result++;
        }

        return result;
    }
}
