package boj.silver._3;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_2579 {
    public static void main(String[] args) {
        // 계단 오르기

        // input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> stairs = new ArrayList<>();
        for(int i=0 ; i<N ; i++)
            stairs.add(sc.nextInt());

        List<Integer> score = new ArrayList<>();
        score.add(stairs.get(0));
        if(N > 1)
            score.add(stairs.get(0) + stairs.get(1));
        if(N > 2)
            score.add(Math.max(stairs.get(0), stairs.get(1)) + stairs.get(2));

        for(int i = 3 ; i< N ; i++)
            score.add(Math.max(score.get(i-3)+stairs.get(i-1), score.get(i-2)) + stairs.get(i));

        // output
        System.out.println(score.get(N-1));
    }
}
