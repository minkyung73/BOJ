package boj.silver._4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_13699 {
    static List<Long> dp = new ArrayList<>(
            Collections.nCopies(36, 1L)
    );

    static void t(int n) {
        if(n == 0 || n == 1) {
            dp.set(n, 1L);
            return ;
        }

        int start = 0;
        int end = n-1;
        long sum = 0;

        int iter = n%2 == 0 ? n/2 : n/2+1;
        for(int i=0 ; i<iter ; i++) {
            if(start == end) sum += dp.get(start) * dp.get(end);
            else sum += dp.get(start) * dp.get(end) * 2;
            start++;
            end--;
        }

        dp.set(n, sum);
    }

    public static void main(String[] args) {
        // 점화식
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0 ; i<=n ; i++) t(i);
        System.out.println(dp.get(n));
    }
}
