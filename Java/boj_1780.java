import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boj_1780 {
    public static void main(String[] args) {
        // 종이의 개수

        // input
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<List<Integer>> paperArr = new ArrayList<>();
        for(int i=0 ; i<N ; i++) {
            String input = sc.nextLine();
            String[] split = input.split(" ");
            List<Integer> row = new ArrayList<>();
            for (String s : split) {
                row.add(Integer.parseInt(s));
            }
            paperArr.add(row);
        }

        for(int i=0 ; i<N ; i++) {
            System.out.println(paperArr.get(i));
        }


    }
}
