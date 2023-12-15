package goorm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class goorm_3_aspiring_developer {
    // 개발자 지망생 구름이의 취업 뽀개기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int result = 0;
        int n = Integer.parseInt(br.readLine());
        int[] difficulty = new int[5];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            difficulty[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> problems = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            problems.add(new ArrayList<>());
        }

        for(int i=0 ; i<n ; i++) {
            st = new StringTokenizer(br.readLine());
            int dif = Integer.parseInt(st.nextToken());
            int min = Integer.parseInt(st.nextToken());

            problems.get(dif - 1).add(min);
        }

        // sort
        for (int i = 0; i < 5; i++) {
            Collections.sort(problems.get(i));
        }

        // calculation
        for(int i=0 ; i<5 ; i++) {
            int num = difficulty[i];
            List<Integer> problem = problems.get(i);

            for(int j=0 ; j<num ; j++) {
                result += problem.get(j);   // 문제 푸는 시간
                // 쉬는 시간
                result += j == num-1 ? 60 : problem.get(j+1) - problem.get(j);
            }
        }
        result -= 60;

        // output
        System.out.println(result);
    }
}
