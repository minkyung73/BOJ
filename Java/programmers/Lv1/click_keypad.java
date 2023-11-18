package programmers.Lv1;

import java.util.*;

class click_keypad {
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    String answer = "";
    int lx = 4, ly = 1;
    int rx = 4, ry = 3;

    public String solution(int[] numbers, String hand) {
        for(int i=0 ; i<numbers.length ; i++)
            keypad(numbers[i], hand);

        return answer;
    }

    public void keypad(int num, String hand) {
        if(num == 1 || num == 4 || num == 7) {
            answer += "L";

            lx = num/3 + 1;
            ly = 1;

            return ;
        }

        if(num == 3 || num == 6 || num == 9) {
            answer += "R";

            rx = num/3;
            ry = 3;

            return ;
        }

        // 2, 5, 8, 0인 경우
        // 1. 목표 좌표
        int target_x, target_y;
        target_x = num == 0 ? 4 : num/3 + 1;
        target_y = 2;

        // 2. 거리 비교
        int dist_L = Math.abs(lx - target_x) + Math.abs(ly - target_y);
        int dist_R = Math.abs(rx - target_x) + Math.abs(ry - target_y);

        if((dist_L < dist_R) || (dist_L == dist_R && hand.equals("left"))) {
            answer += "L";
            lx = target_x;
            ly = target_y;
        }
        else if((dist_R < dist_L) || (dist_L == dist_R && hand.equals("right"))) {
            answer += "R";
            rx = target_x;
            ry = target_y;
        }
    }
}
