import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_10989 {
    // 수 정렬하기 3

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        for(int i=0 ; i<n ; i++) sb.append(arr[i] + "\n");
        System.out.println(sb);
    }
}
