package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class swea_1285 {
    // 아름이의 돌 던지기
    private static int n, min = 100000;
    private static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ;j<n ;j++) {
                int temp = Integer.parseInt(st.nextToken());
                list.add(temp);
                min = Math.min(min, Math.abs(temp));
            }

            sb.append("#" + (i+1) + " " + min + " " + rock() + "\n");
        }
        System.out.println(sb);
    }

    public static int rock() {
        int cnt = 0;

        for (Integer num : list) {
            if(Math.abs(num) == min) cnt++;;
        }

        return cnt;
    }
}
