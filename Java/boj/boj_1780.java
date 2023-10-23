package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_1780 {
    public static int cnt_1 = 0;
    public static int cnt0 = 0;
    public static int cnt1 = 0;
    public static List<List<Integer>> paperArr = new ArrayList<>();

    public static void main(String[] args) {
        // 종이의 개수

        // input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for(int i=0 ; i<N ; i++) {
            String input = sc.nextLine();
            String[] split = input.split(" ");
            List<Integer> row = new ArrayList<>();
            for (String s : split) {
                row.add(Integer.parseInt(s));
            }
            paperArr.add(row);
        }

        // function call
        cutPaper(0, 0, N);

        // output
        System.out.println(cnt_1);
        System.out.println(cnt0);
        System.out.println(cnt1);
    }

    public static void cutPaper(int row, int col, int size) {

        if(numCheck(row, col, size)) {  // 숫자가 모두 같다
            int countNum = paperArr.get(row).get(col);
            if(countNum == -1) cnt_1++;
            else if(countNum == 0) cnt0++;
            else if(countNum == 1) cnt1++;
            return ;
        }

        int newSize = size/3;

        cutPaper(row, col, newSize);
        cutPaper(row, col + newSize, newSize);
        cutPaper(row, col + 2*newSize, newSize);

        cutPaper(row + newSize, col, newSize);
        cutPaper(row + newSize, col + newSize, newSize);
        cutPaper(row + newSize, col  + 2*newSize, newSize);

        cutPaper(row + 2*newSize, col, newSize);
        cutPaper(row + 2*newSize, col + newSize, newSize);
        cutPaper(row + 2*newSize, col + 2*newSize, newSize);
    }

    public static boolean numCheck(int row, int col, int size) {
        int initNum = paperArr.get(row).get(col);

        for(int i=row ; i<row+size ; i++) {
            for(int j=col ; j<col+size ; j++) {
                if(paperArr.get(i).get(j) != initNum)
                    return false;
            }
        }

        return true;
    }
}
