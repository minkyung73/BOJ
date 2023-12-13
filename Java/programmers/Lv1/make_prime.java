package programmers.Lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class make_prime {
    // 소수 만들기

    public static void main(String[] args) throws IOException {
        int[] nums = {1, 2, 3, 4};
        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;

        // step 1. 3개의 수 조합
        List<List<Integer>> num_list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        combination(nums, visited, 0, 3, num_list);

        // step 2. 소수 판별
        for(int i=0 ; i< num_list.size() ; i++) {
            // 3개 수의 합
            int num = 0;
            for(int j=0 ;j<3 ; j++)
                num += num_list.get(i).get(j);

            // num 값이 소수인지 판별
            boolean flag = true;
            for(int j=2 ; j<num ; j++) {
                if(num % j == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }

        return answer;
    }

    public static void combination(int[] arr, boolean[] visited, int start, int r, List<List<Integer>> num_list) {
        if(r == 0) {
            num_list.add(print(arr, visited));
            return;
        }

        for(int i=start ; i<arr.length ; i++) {
            visited[i] = true;
            combination(arr, visited, i+1, r-1, num_list);
            visited[i] = false;
        }
    }

    public static List<Integer> print(int[] arr, boolean[] visited) {
        List<Integer> comb = new ArrayList<>();
        for(int i=0 ; i<arr.length ; i++) {
            if(visited[i])
                comb.add(arr[i]);
        }

        return comb;
    }
}
