package programmers.Lv1;

import java.util.*;

class numeric_str_and_words {
    public int solution(String s) {
        int answer = 0;

        List<String> numbers = new ArrayList<>(
                Arrays.asList("zero", "one", "two", "three", "four",
                        "five", "six", "seven", "eight", "nine"));

        for(int i=0 ; i<10 ; i++) {
            String num = numbers.get(i);

            while(s.contains(num)) {
                s = s.replace(num, String.valueOf(i));
            }
        }

        answer = Integer.parseInt(s);
        return answer;
    }
}