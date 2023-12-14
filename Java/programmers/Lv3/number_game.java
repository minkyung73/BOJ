package programmers.Lv3;

import java.io.IOException;
import java.util.Arrays;

public class number_game {
    public static void main(String[] args) throws IOException {
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};

        System.out.println(solution(A, B));
    }

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        int n = B.length;
        int A_idx = 0, B_idx = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        for(int i=0 ; i<n ; i++) {
            if(A[A_idx] < B[B_idx]) {
                answer++;
                A_idx++;
            }

            B_idx++;
        }

        return answer;
    }
}
