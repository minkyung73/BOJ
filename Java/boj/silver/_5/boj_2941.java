package boj.silver._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class boj_2941 {
    // 크로아티아 알파벳

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        List<String> list = new ArrayList<>(Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="));
        int cnt = 0;

        for(int i=0 ; i<list.size() ; i++) {
            while(str.contains(list.get(i))) {
                int idx = str.indexOf(list.get(i));
                int len = list.get(i).length();
                str = str.substring(0, idx) + " " + str.substring(idx+len);
                cnt++;
            }
        }
        str = str.replaceAll(" ", "");

        // output
        System.out.println(cnt + str.length());
    }
}
