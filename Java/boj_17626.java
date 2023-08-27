import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class boj_17626 {
    public static void main(String[] args) {
        // Four Squares
        Scanner sc = new Scanner(System.in);

        // input
        int n = sc.nextInt();

        List<Integer> dp = new ArrayList<>(
                Collections.nCopies(50001, 0)
        );
        dp.set(0, 0);
        dp.set(1, 1);

        int result = solve(dp, n);
        System.out.println(result);
    }

    static int solve(List<Integer> dp, int n) {
        for(int i=2 ; i<= n ; i++) {
            int min = Integer.MAX_VALUE;
            for(int j=1 ; j*j<=i ; j++) {
                min = Math.min(min, dp.get(i - j*j));
            }
            dp.set(i, min + 1);
        }

        return dp.get(n);
    }
}
