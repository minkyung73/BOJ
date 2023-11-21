package programmers.Lv1;

import java.util.*;

class budget {
    // greedy
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int sum = 0;
        for(int i=0 ; i<d.length ; i++) {
            if(sum + d[i] <= budget) {
                sum += d[i];
                answer++;
            }

            if(sum >= budget) break;
        }

        return answer;
    }
}