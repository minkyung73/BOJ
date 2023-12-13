package programmers.Lv1;

import java.io.IOException;
import java.util.*;

class numeric_str_and_words {

    public static void main(String[] args) throws IOException {
        String s = "one4seveneight";

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;

        List<String> str_arr = new ArrayList<>(
                Arrays.asList("zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine"));

        for(int i=0 ; i<10 ; i++) {
            while (s.contains(str_arr.get(i))) {
                s = s.replace(str_arr.get(i), String.valueOf(i));
            }
        }

        return Integer.parseInt(s);
    }
}