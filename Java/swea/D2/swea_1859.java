package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_1859 {
    // 백만 장자 프로젝트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<n ; j++) arr[j] = Integer.parseInt(st.nextToken());

            sb.append("#" + (i+1) + " " + f(arr) + "\n");
        }
        System.out.println(sb);
    }

    public static long f(int[] arr) {
        long result = 0, max = arr[arr.length-1];

        for(int i=arr.length-2 ; i>= 0 ; i--) {
            if(arr[i] < max) result += max - arr[i];
            else if(arr[i] > max) max = arr[i];
        }

        return result;
    }

}
