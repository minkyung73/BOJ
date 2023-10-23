package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_18110 {
    // solved.ac

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0 ; i<n ; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int cut = (int) Math.round(n*0.15);
        double sum = 0;
        for(int i=cut ; i<n-cut ; i++)
            sum += arr[i];

        System.out.println(Math.round(sum/(n-2*cut)));
    }
}
