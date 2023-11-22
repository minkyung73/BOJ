package programmers.Lv2;

import java.util.*;

class numeric_game {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int idxA = 0, idxB = 0;

        for(int i=0 ; i<A.length ; i++) {
            if(idxA >= A.length || idxB >= B.length)
                break;

            if(A[idxA] > B[idxB])
                idxB++;
            else if(A[idxA] < B[idxB]) {
                answer++;
                idxA++;
                idxB++;
            }
            else {
                idxB++;
            }
        }

        return answer;
    }
}
