package boj.gold._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// AC
public class boj_5430 {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();

    public static String command;
    public static int n;
    public static List<Integer> list;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            init();
            solution();
        }
        System.out.println(sb);
    }

    public static void init() throws IOException{
        command = br.readLine();
        n = Integer.parseInt(br.readLine());

        String str = br.readLine();
        str = str.substring(1, str.length()-1);
        String[] split = str.split(",");
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(split[i]));
        }
    }

    public static void solution() {
        boolean isReversed = false;

        for (int i = 0; i < command.length(); i++) {
            char c = command.charAt(i);

            if(c == 'R') isReversed = !isReversed;
            else {
                if(list.isEmpty()) {
                    sb.append("error\n");
                    return;
                }

                if(isReversed) list.remove(list.size()-1);
                else list.remove(0);
            }
        }

        // result
        sb.append("[");
        if(!isReversed) {
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i));
                if(i != list.size()-1) sb.append(",");
            }
        }
        else {
            for (int i = list.size()-1; i >= 0 ; i--) {
                sb.append(list.get(i));
                if(i != 0) sb.append(",");
            }
        }
        sb.append("]\n");
    }
}
