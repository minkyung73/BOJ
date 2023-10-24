package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class swea_1288 {
    // 새로운 불면증 치료법
    private static int n;
    private static List<Boolean> check;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int i=0 ; i<T ; i++) {
            n = sc.nextInt();
            check = new ArrayList<>(
                    Collections.nCopies(10, false)
            );

            // function call
            sb.append("#" + (i+1) + " " + sheep() + "\n");
        }
        System.out.println(sb);
    }

    public static int sheep() {
        int result = n, cnt = 1;

        while (check.contains(false)) {
            int temp = result;

            while (temp > 0) {
                int num = temp % 10;
                temp /= 10;
                if(!check.get(num)) check.set(num, true);
            }

            cnt++;
            result = n * cnt;
        }

        return n * (cnt-1);
    }

}
