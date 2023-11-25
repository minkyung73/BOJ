package boj.silver._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1764 {
    // 듣보잡

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
            map.put(br.readLine(), 1);
        }

        for(int i=0 ; i<m ; i++) {
            String str = br.readLine();
            map.put(str, map.getOrDefault(str, 0) + 1);

            if(map.get(str) == 2)
                result.add(str);
        }
        Collections.sort(result);

        sb.append(result.size() + "\n");
        for(int i=0 ; i<result.size() ; i++)
            sb.append(result.get(i) + "\n");

        System.out.println(sb);
    }
}
