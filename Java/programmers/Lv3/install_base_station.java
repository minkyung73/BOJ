package programmers.Lv3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class install_base_station {
    // 기지국 설치

    public static void main(String[] args) throws IOException {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;

        System.out.println(solution(n, stations, w));
    }

    public static int count(int size, int cover) {
        int res = size/cover;
        if(size % cover != 0) res++;
        return res;
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int start = 1;

        for(int i=0 ; i<stations.length ; i++) {
            int end = stations[i] - w - 1;

            if(end >= start) {
                // count
                answer += count(end-start+1, 2*w+1);
            }

            start = stations[i] + w + 1;
        }

        if(start <= n) {
            answer += count(n-start+1, 2*w+1);
        }

        return answer;
    }
}
