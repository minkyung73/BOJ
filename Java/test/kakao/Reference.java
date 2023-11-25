package test.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reference {
    public static void main(String[] args) throws IOException {
        // Integer ArrayList to int array
        ArrayList<Integer> list = new ArrayList<>();
        int[] arr = list.stream()
                .mapToInt(i -> i)
                .toArray();

        List<Integer> list_B = Arrays.stream(arr).boxed().collect(Collectors.toList());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }

    public static int solution(String[] friends, String[] gifts) {
        int answer = 0;



        return answer;
    }
}
