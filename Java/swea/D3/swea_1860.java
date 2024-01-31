package swea.D3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_1860 {
    // 진기의 최고급 붕어빵
    static int n, m, k;
    static int fish, sec;
    static String ans;
    static List<Integer> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // initialize
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new ArrayList<>();
            fish = 0;
            sec = 0;

            // 손님
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++)
                arr.add(Integer.parseInt(st.nextToken()));
            Collections.sort(arr);

            // function call
            ans = calc() ? "Possible" : "Impossible";

            // result
            sb.append("#" + (i+1) + " " + ans + "\n");
        }

        // output
        System.out.println(sb);
    }

    public static boolean calc() {
        int max_sec = arr.get(n-1);

        for (int i = 0; i <= max_sec; i++) {
            // 붕어빵 제조
            if(i != 0 && i % m == 0) fish += k;

            // 지금 손님이 없다면
            if(arr.get(0) != i) continue;

            // 손님이 온다면
            if (fish <= 0) {
                return false;
            } else {
                fish -= 1;
                arr.remove(0);
            }
        }

        return true;
    }
}
