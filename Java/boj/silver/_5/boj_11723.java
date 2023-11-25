package boj.silver._5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_11723 {
    // 집합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int num;

            if(command.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                if(!arr.contains(num)) arr.add(num);
            }
            else if(command.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                if(arr.contains(num)) arr.remove(arr.indexOf(num));
            }
            else if(command.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                if(arr.contains(num)) sb.append("1\n");
                else sb.append("0\n");
            }
            else if(command.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                if(arr.contains(num)) arr.remove(arr.indexOf(num));
                else arr.add(num);
            }
            else if(command.equals("all")) {
                arr.clear();
                for(int j=0 ; j<20 ; j++) arr.add(j+1);
            }
            else if(command.equals("empty"))
                arr.clear();
        }

        System.out.println(sb);
    }
}
