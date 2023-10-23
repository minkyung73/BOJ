package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_1630 {
    public static List<List<Integer>> paperArr = new ArrayList<>();
    public static int white = 0; // 0
    public static int blue = 0; // 1

    public static void main(String[] args) {
        // 색종이 만들기

        // input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        for(int i=0 ; i<N ; i++) {
            String row = sc.nextLine();
            String[] row_split = row.split(" ");
            List<Integer> row_list = new ArrayList<>();
            for (String s : row_split) {
                row_list.add(Integer.parseInt(s));
            }
            paperArr.add(row_list);
        }

        // function call
        cutPaper(0, 0, N);
        System.out.println(white);
        System.out.println(blue);

    }

    public static void cutPaper(int row, int col, int size) {
        if(colorCheck(row, col, size)) {
            if(paperArr.get(row).get(col) == 0) white++;
            else blue++;
            return;
        }

        int newSize = size/2;

        cutPaper(row, col, newSize);
        cutPaper(row, col+newSize, newSize);
        cutPaper(row+newSize, col, newSize);
        cutPaper(row+newSize, col+newSize, newSize);
    }

    public static boolean colorCheck(int row, int col, int size) {
        int initColor = paperArr.get(row).get(col);
        for(int i=row ; i<row+size ; i++) {
            for(int j=col ; j<col+size ; j++) {
                if (paperArr.get(i).get(j) != initColor)
                    return false;
            }
        }

        return true;
    }
}
