package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2056 {
    // 연월일 달력

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            String str = br.readLine();
            int month = Integer.parseInt(str.substring(4, 6));
            int day = Integer.parseInt(str.substring(6, 8));

            if(f(month, day)) {
                sb.append("#" + (i+1) + " " + str.substring(0, 4) + "/"
                        + str.substring(4, 6) + "/"
                        + str.substring(6, 8) + "\n");
            }
            else sb.append("#" + (i+1) + " " + -1 + "\n");
        }
        System.out.println(sb);
    }

    public static boolean f(int m, int d) {
        if(m < 1 || m > 12) return false;

        if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            if(d < 1 || d > 31) return false;
        }

        if(m == 2) {
            if(d < 1 || d > 28) return false;
        }

        if(m == 4 || m == 6 || m == 9 || m == 11) {
            if(d < 1 || d > 30) return false;
        }

        return true;
    }
}
