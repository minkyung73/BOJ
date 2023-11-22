package programmers.Lv2;

import java.util.*;

class tuple {
    public int[] solution(String s) {
        int[] answer;
        List<Integer> result = new ArrayList<>();

        // n-tuple 만들기
        String[] tuple_str = s.split("},");
        answer = new int[tuple_str.length];

        for(int i=0 ; i<tuple_str.length ; i++) {
            tuple_str[i] = tuple_str[i].replace("{", "");
            tuple_str[i] = tuple_str[i].replace("}", "");
        }

        // 길이 순서대로 정렬
        Arrays.sort(tuple_str, (o1, o2) -> o1.length() < o2.length() ? -1 : 1);

        // 원소 구하기
        for(int i=0 ; i<tuple_str.length ; i++) {
            String[] temp = tuple_str[i].split(",");

            for(int j=0 ; j<temp.length ; j++) {
                int num = Integer.parseInt(temp[j]);
                if(!result.contains(num)) {
                    result.add(num);
                }
            }
        }

        for(int i=0 ; i<result.size() ; i++)
            answer[i] = result.get(i);

        return answer;
    }
}
