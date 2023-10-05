import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815 {
    // 숫자 카드

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // n input
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<n ; i++)
            arr1[i] = Integer.parseInt(st.nextToken());

        // m input
        int m = Integer.parseInt(br.readLine());
        int[] arr2 = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0 ; i<m ; i++)
            arr2[i] = Integer.parseInt(st.nextToken());

        // binary search
        Arrays.sort(arr1);
        for(int i=0 ; i<m ; i++) {
            int r = binarySearch(arr1, arr2[i]);
            System.out.print(r + " ");
        }
    }

    public static int binarySearch(int[] arr, int key) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int mid = (l+r)/2;

            if(key == arr[mid]) {
                return 1;
            }
            if(key < arr[mid]) {
                r = mid;
            }
            else if(key > arr[mid]) {
                l = mid+1;
            }
        }

        return 0;
    }
}
