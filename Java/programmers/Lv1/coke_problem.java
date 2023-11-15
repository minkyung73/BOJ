package programmers.Lv1;

import java.util.*;
// 콜라 문제
class coke_problem {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int temp;

        while(n>=a) {
            temp = (n/a)*b;
            answer += temp;
            n = temp + n%a;
        }

        return answer;
    }
}
