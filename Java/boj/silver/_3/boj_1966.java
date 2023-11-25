package boj.silver._3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1966 {
    public static void main(String[] args) throws IOException {
        // 프린터 큐

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[][] nm = new int[t][2];
        Queue<Integer> origin = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        int [] result = new int[t];

        for(int i=0 ; i<t ; i++) {
            origin.clear();
            queue.clear();

            // n & m input
            StringTokenizer st = new StringTokenizer(br.readLine());
            nm[i][0] = Integer.parseInt(st.nextToken());
            nm[i][1] = Integer.parseInt(st.nextToken());

            // origin input
            st = new StringTokenizer(br.readLine());
            for (int j=0 ; j < nm[i][0] ; j++) {
                origin.add(Integer.parseInt(st.nextToken()));
            }

            // 우선 순위 대로 정렬 && m번째 인덱스의 변한 위치 찾기
            int cnt = 0, cur_idx = nm[i][1];

            while (!origin.isEmpty()) {
                int flag = 1;
                int temp = origin.peek();

                for (Integer o : origin) {
                    if(o > temp) {
                        origin.add(origin.poll());
                        flag = 0;
                        break;
                    }
                }

                if(flag == 1) {
                    queue.add(origin.poll());
                    cnt++;

                    if(cur_idx == 0) break;
                }

                if(cur_idx == 0) {
                    cur_idx = origin.size()-1;
//                    System.out.println(12345);
                }
                else cur_idx--;

//                System.out.println(origin);
//                System.out.println(cnt + " " + cur_idx + "\n");
            }

            result[i] = cnt;
        }
        
        // output
        for (int i=0 ; i<t ; i++) System.out.println(result[i]);
    }
}
