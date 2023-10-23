package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_14916 {
    public static void main(String[] args) {
        // 거스름돈

        Scanner sc = new Scanner(System.in);

        int change = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();

        int i=0;
        while(true) {
            if(change < 5 * i) break;

            if((change - 5*i)%2 != 0) {
                i++;
                continue;
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add((change-5*i)/2);
                list.add(temp);
            }

            i++;
        }

        int change_num = change;
        if(list.isEmpty()) System.out.println(-1);
        else {
            for (List<Integer> l : list) {
                 if(l.get(0) + l.get(1) < change_num)
                     change_num = l.get(0) + l.get(1);
            }
            System.out.println(change_num);
        }
    }
}
