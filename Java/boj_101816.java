import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_101816 {
    // 숫자 카드 2

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // n input
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] n_arr = new int[n];
        for(int i=0 ; i<n ; i++)
            n_arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(n_arr);

        // m input
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] m_arr = new int[m];
        for(int i=0 ; i<m ; i++) {  // counting
            int key = Integer.parseInt(st.nextToken());
            int result = upperBound(n_arr, key) - lowerBound(n_arr, key);
            sb.append(result + " ");
        }

        // output
        System.out.println(sb);
    }

    private static int lowerBound(int[] arr, int key) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l+r)/2;

            if(key <= arr[mid]) r = mid;
            else l = mid+1;
        }

        return l;
    }

    private static int upperBound(int[] arr, int key) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l+r)/2;

            if(key >= arr[mid]) l = mid+1;
            else r = mid;
        }

        return r;
    }
}
