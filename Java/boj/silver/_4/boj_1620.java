package boj.silver._4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1620 {
    // 나는야 포켓몬 마스터 이다솜

    public static boolean isNumeric(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        List<String> names = new ArrayList<>();
//        for(int i=0 ; i<n ; i++) {
//            names.add(br.readLine());
//
//        for(int i=0 ; i<m ; i++) {
//            String str = br.readLine();
//
//            if(isNumeric(str)) {
//                int idx = Integer.parseInt(str);
//                sb.append(names.get(idx-1) + "\n");
//            }
//            else {
//                int idx = names.indexOf(str);
//                sb.append(idx+1 + "\n");
//            }
//        }


        Map<String, Integer> names1 = new TreeMap<>();
        Map<Integer, String> names2 = new TreeMap<>();
        for(int i=1 ; i<=n ; i++) {
            String str = br.readLine();
            names1.put(str, i);
            names2.put(i, str);
        }

        for(int i=0 ; i<m ;i++) {
            String str = br.readLine();

            if (isNumeric(str)) {
                int idx = Integer.parseInt(str);
                sb.append(names2.get(idx) + "\n");
            }
            else {
                sb.append(names1.get(str) + "\n");
            }
        }

        System.out.println(sb);
    }
}
