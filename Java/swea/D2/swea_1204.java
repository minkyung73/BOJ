package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class swea_1204 {
    // 최빈수 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0 ; j<1000 ; j++) {
                int key = Integer.parseInt(st.nextToken());
                map.put(key, map.getOrDefault(key, 1) + 1);
            }

            int max = Collections.max(map.values());
            int max_key = 0;
            for (Integer key : map.keySet()) {
                if(map.get(key).equals(max)) {
                    max_key = Math.max(max_key, key);
                }
            }
            sb.append("#" + (i+1) + " " + max_key + "\n");
        }
        System.out.println(sb);
    }
}
