package programmers.Lv2;

import java.io.IOException;
import java.util.*;

public class jump_and_teleport {
    public static void main(String[] args) throws IOException {
        int n = 5;

        System.out.println(solution(n));
    }
    public static int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if(n % 2 != 0)
                ans++;

            n/=2;
        }

        return ans;
    }
}
