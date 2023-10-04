import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2231 {
    // 분해합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean flag = false;

        for(int i=0 ; i<n ; i++) {
            int sum = i;
            int value = i;

            while (value != 0) {
                sum += value % 10;
                value /= 10;
            }

            if(n == sum) {
                System.out.println(i);
                flag = true;
                break;
            }
        }

        if(!flag) System.out.println(0);

    }
}
