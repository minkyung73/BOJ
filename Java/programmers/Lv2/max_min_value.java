package programmers.Lv2;

import java.util.*;
// 최댓값과 최솟값
class max_min_value {
    public String solution(String s) {
        String answer = "";

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        String[] arr = s.split(" ");
        for(int i=0 ; i<arr.length ; i++) {
            int num = Integer.parseInt(arr[i]);

            if(num < min) min = num;
            if(num > max) max = num;
        }

        answer = String.valueOf(min) + " " + String.valueOf(max);

        return answer;
    }
}
