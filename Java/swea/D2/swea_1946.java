package swea.D2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class swea_1946 {
    // 간단한 압축 풀기
    private static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int i=0 ; i<T ; i++) {
            sb.append("#" + (i+1) + "\n");

            n = Integer.parseInt(br.readLine());
            TreeMap<String, Integer> map = new TreeMap<>();

            for(int j=0 ; j<n ; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                map.put(str, num);
            }

            //
            int width = 0;
            for (String key : map.keySet()) {
                int num = map.get(key);

                while (num > 0) {
                    if(width == 10) {
                        sb.append("\n");
                        width = 0;
                    }
                    sb.append(key);
                    num--;
                    width++;
                }
            }
            sb.append("\n");
        }
        // output
        System.out.println(sb);
    }
}
