package boj.silver._2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18870 {
    // 좌표 압축
    private static int n;
    private static int[] arr, sorted;
    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        // arr, sorted
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        sorted = new int[n];
        for(int i=0 ; i<n ; i++)
            sorted[i] = arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(sorted);

        // map
        int rank = 0;
        for(int i=0 ; i<n ; i++) {
            if(!map.containsKey(sorted[i]))
                map.put(sorted[i], rank++);
        }

        // sb
        for(int i=0 ; i<n ; i++) {
            int result = map.get(arr[i]);
            sb.append(result + " ");
        }

        // output
        System.out.println(sb);
    }
}
