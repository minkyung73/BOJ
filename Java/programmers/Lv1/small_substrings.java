package programmers.Lv1;

import java.util.*;
// 크기가 작은 부분 문자열
class small_substrings {
    public int solution(String t, String p) {
        int answer = 0;
        long p_num = Long.parseLong(p);

        for(int i=0 ; i<=t.length()-p.length() ; i++) {
            long t_num = Long.parseLong(t.substring(i, i+ (p.length())));

            if(t_num <= p_num) answer++;
        }

        return answer;
    }
}