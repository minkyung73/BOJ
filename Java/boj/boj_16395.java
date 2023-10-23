package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj_16395 {
    public static void main(String[] args) {
        // 파스칼의 삼각형
        Scanner sc = new Scanner(System.in);

        // input
        int n = sc.nextInt();
        int k = sc.nextInt();

        // pascal
        List<Integer> pre_arr = new ArrayList<>();
        List<Integer> cur_arr = new ArrayList<>();
        pre_arr.add(0);
        pre_arr.add(1);
        pre_arr.add(0);

        for (int i=1 ; i<n ; i++) {
            cur_arr.clear();
            cur_arr.add(0);
            for(int j=1 ; j<=i+1 ; j++) {
                cur_arr.add(pre_arr.get(j-1) + pre_arr.get(j));
            }
            cur_arr.add(0);

            // init
            pre_arr.clear();
            pre_arr.addAll(cur_arr);
        }

        // output
        if(n <= 2) System.out.println("1");
        else System.out.println(cur_arr.get(k));

    }
}
