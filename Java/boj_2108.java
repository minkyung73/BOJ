import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2108 {
    // 통계학

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        // 산술평균
        int sum = 0;
        for(int i=0 ; i<n ; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        System.out.println((int) Math.round((double)sum/n));

        // 중앙값
        Arrays.sort(arr);
        System.out.println(arr[n/2]);

        // 최빈값
        int cnt = 0, max = -1, key = arr[0];
        boolean check = false;
        for(int i=0 ; i<n-1 ; i++) {
            if(arr[i] == arr[i+1]) cnt++;
            else cnt = 0;

            if(max < cnt) { // 더 큰 최빈값이 있을 경우
                max = cnt;
                key = arr[i];
                check = true;
            }
            else if(max == cnt && check) {
                key = arr[i];
                check = false;
            }
        }
        System.out.println(key);

        // 범위
        System.out.println(arr[n-1] - arr[0]);
    }
}
