package programmers.Lv2;

import java.util.*;

class carpet {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int sum = brown + yellow;
        int y_width=0, y_height=0;
        int b_width=0, b_height=0;

        for(int i=3 ; i<= Math.sqrt(sum) ; i++) {
            if(sum % i != 0) continue;

            b_height = i;
            b_width = sum / b_height;

            y_height = b_height - 2;
            y_width = b_width - 2;

            if((b_height*b_width) - (y_height*y_width) == brown) {
                break;
            }
        }

        answer[0] = (int) b_width;
        answer[1] = (int) b_height;

        return answer;
    }
}
