package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1912 {
    static List<Integer> list = new ArrayList<>();
    static List<Integer> dp = new ArrayList<>(
            Collections.nCopies(100000, 0)
    );
    static int max = 0;

    public static void main(String[] args) throws IOException {
        // 연속합

        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i=0 ; i<n ; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        
        dp.set(0, list.get(0));
        max = dp.get(0);

        for(int i= 1; i<n ; i++) {
            dp.set(i, Math.max(dp.get(i-1) + list.get(i), list.get(i)));
            max = Math.max(max, dp.get(i));
        }

        // output
        System.out.println(max);
    }
}
